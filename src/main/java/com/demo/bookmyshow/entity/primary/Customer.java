package com.demo.bookmyshow.entity.primary;

import com.demo.bookmyshow.entity.secondary.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer
{
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @Column(name = "customer_id", columnDefinition = "BIGINT")
    private Long customerId;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(15)")
    private String phoneNumber;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "date_of_birth", columnDefinition = "DATE")
    private LocalDate dateOfBirth;

    @Column(name = "rrn", columnDefinition = "VARCHAR(80)")
    private String rrn;

    @Column(name = "rrn", columnDefinition = "VARCHAR(80)")
    private String referenceNumber;

    @Column(name = "is_phone_number_verified", columnDefinition = "BOOLEAN")
    private boolean isPhoneNumberVerified;

    @Column(name = "updated_at", columnDefinition = "timestamp")
    private LocalDateTime updatedAt;

    @Column(name = "status", columnDefinition = "VARCHAR(50)")
    private String status;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<PaymentMethod> paymentMethods;
}
