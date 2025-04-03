package com.demo.bookmyshow.service;

import com.demo.bookmyshow.repository.secondary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import com.demo.bookmyshow.entity.secondary.User;

import java.util.Map;

@Service
public class AuthService
{
    @Autowired
    private UserRepository userRepository;

    public User processGoogleUser(OAuth2User oAuth2User) {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        String email = (String) attributes.get("email");
        String username = (String) attributes.get("name");
        String provider = "google";

        // Check if user exists
        User existingUser = userRepository.findByEmail(email).orElse(null);

        if (existingUser == null) {
            // New user - Sign up
            User newUser = new User(username, email, provider);
            return userRepository.save(newUser);
        } else {
            // Existing user - Update if needed
            existingUser.setUsername(username);
            return userRepository.save(existingUser);
        }
    }
}
