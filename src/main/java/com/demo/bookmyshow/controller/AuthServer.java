package com.demo.bookmyshow.controller;

import com.demo.bookmyshow.dto.response.GoogleSignupResponse;
import com.demo.bookmyshow.entity.secondary.User;
import com.demo.bookmyshow.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthServer
{
    @Autowired
    private AuthService authService;

    // Step 1: Initiate Google OAuth flow
    @GetMapping("/signup")
    public ResponseEntity<String> initiateGoogleSignup() {
        String googleAuthUrl = "http://localhost:8082/oauth2/authorization/google";
        return ResponseEntity.ok(googleAuthUrl);
    }

    // Step 2: Handle callback and process signup
    @GetMapping("/callback")
    public ResponseEntity<?> handleGoogleCallback(
            @RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient authorizedClient,
            OAuth2User oAuth2User) {

        if (oAuth2User != null) {
            // Process the user and save to database
            User user = authService.processGoogleUser(oAuth2User);

            // Return user details
            return ResponseEntity.ok(new GoogleSignupResponse(user.getId(), user.getEmail(), user.getUsername()));
        }
        return ResponseEntity.badRequest().body("Failed to authenticate with Google");
    }
}
