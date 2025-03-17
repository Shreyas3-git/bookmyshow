package com.demo.bookmyshow.controller;

import com.demo.bookmyshow.entity.UserProfile;
import com.demo.bookmyshow.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookMyShowController
{

    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/public/shows")
    public String getShows() {
        return "List of available shows";
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public UserProfile getProfile(Authentication authentication) {
        String email = authentication.getName(); // Extracted from JWT
        return userProfileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }
}
