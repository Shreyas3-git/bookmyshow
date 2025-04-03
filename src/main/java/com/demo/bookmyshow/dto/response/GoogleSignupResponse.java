package com.demo.bookmyshow.dto.response;

public class GoogleSignupResponse
{
    private Long id;
    private String email;
    private String username;

    public GoogleSignupResponse(Long id, String email, String username) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

    // Getters
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }

}
