package com.demo.bookmyshow.configsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/errors",
                                "/.well-known/openid-configuration"
                                ,"/api/getPdf",
                                "/api/auth/google/**",
                                "/signup",      // Allow access to initiate Google signup
                                "/callback"     // Allow access to callback endpoint
                        ).permitAll()
                        .requestMatchers("/bookmyshow/api/**","/bookmyshow/admin/**").authenticated()
                )
//                .oauth2Login(oauth2 -> oauth2
//                        .loginProcessingUrl("/api/auth/google/callback")
//                        .defaultSuccessUrl("/api/auth/google/success", true)
//                        .failureUrl("/api/auth/google/failure")
//                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(jwtAuthenticationConverter())
                        )
                );
        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
            List<String> roles = jwt.getClaimAsStringList("roles");
            if (roles == null) {
                String rolesStr = jwt.getClaimAsString("roles");
                roles = rolesStr != null ? Arrays.asList(rolesStr.split(" ")) : Collections.emptyList();
            }
            return roles.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()))
                    .collect(Collectors.toList());
        });
        return converter;
    }

}