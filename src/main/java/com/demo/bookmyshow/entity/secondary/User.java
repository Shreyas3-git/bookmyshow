package com.demo.bookmyshow.entity.secondary;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;
    private String provider;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles;

    public User(String username, String email, String provider) {
        this.username = username;
        this.email = email;
        this.provider = provider;
    }

}
