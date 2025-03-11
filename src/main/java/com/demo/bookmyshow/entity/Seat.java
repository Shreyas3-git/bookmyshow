package com.demo.bookmyshow.entity;

import jakarta.persistence.*;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seat")
@AllArgsConstructor
@NoArgsConstructor
public class Seat
{
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @Column(name = "seat_id",columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "seat_number",columnDefinition = "VARCHAR(55)")
    private String seatNumber;

    @Column(name = "seat_number",columnDefinition = "BIT")
    private boolean isBooked;

    //gold,diamond,silver
    private String catagory;
}
