package com.demo.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="payment_method")
@Data
public class PaymentMethod
{
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @Column(name = "payment_id",columnDefinition = "BIGINT")
    private Long paymentId;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private String cardHolderName;

    private String cardNumber;

    private LocalDate expireIn;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    private String cvv;

    private String cardName;

    private String upiId;
    private String upiApp;

    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
