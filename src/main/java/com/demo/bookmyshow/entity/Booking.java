package com.demo.bookmyshow.entity;


import com.demo.bookmyshow.entity.oauth.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
public class Booking
{
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @Column(name = "booking_id",columnDefinition = "BIGINT")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToMany
    @JoinTable(
            name = "booking_seats",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<Seat> seats;

    @OneToMany(mappedBy = "cartItems",cascade = CascadeType.ALL)
    private List<Item> cartItems;

    @Column(name = "total_amount",columnDefinition = "DOUBLE")
    private Double totalAmount;

    @Column(name = "status",columnDefinition = "VARCHAR(50)")
    private String status;
}
