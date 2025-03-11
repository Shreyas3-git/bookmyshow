package com.demo.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @Column(name = "user_id",columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "first_name",columnDefinition = "VARBINARY(255)")
    private byte[] firstName;
    @Column(name = "last_name",columnDefinition = "VARBINARY(255)")
    private byte[] lastName;

    @Column(name = "mobile_number",columnDefinition = "VARBINARY(255)")
    private byte[] mobileNumber;

    @Column(name = "email_id",columnDefinition = "VARBINARY(255)")
    private byte[] emailId;

    @Column(name = "address",columnDefinition = "VARCHAR(100)")
    private String address;

    @Column(name = "pin_code",columnDefinition = "INT")
    private int pinCode;

    @Column(name = "password",columnDefinition = "VARCHAR(100)")
    private String password;

    private String rrn;

    private LocalDateTime createAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Booking> booking;

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
