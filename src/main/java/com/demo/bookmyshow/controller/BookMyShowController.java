package com.demo.bookmyshow.controller;

import com.demo.bookmyshow.entity.secondary.User;
import com.demo.bookmyshow.repository.secondary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookMyShowController
{

    @Autowired
    private UserRepository userProfileRepository;

    @PostMapping("/public/shows")
    @PreAuthorize("isAuthenticated()")
    public String getShows(Authentication authentication) {
        String email = authentication.getName(); // Extracted from JWT
        System.out.println("customer email => "+email);
        userProfileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        return "List of available shows";
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public User getProfile(Authentication authentication) {
        String email = authentication.getName(); // Extracted from JWT
        return userProfileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }


}
