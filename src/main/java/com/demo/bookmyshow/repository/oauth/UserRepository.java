package com.demo.bookmyshow.repository.oauth;

import com.demo.bookmyshow.entity.oauth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findByEmail(String emailId);
}
