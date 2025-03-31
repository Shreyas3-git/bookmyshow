package com.demo.bookmyshow.entity.primary;

import com.demo.bookmyshow.entity.secondary.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Booking> bookings;

//    @OneToOne
//    @JoinColumn(name = "id")
//    private User user;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<PaymentMethod> paymentMethods;
}
