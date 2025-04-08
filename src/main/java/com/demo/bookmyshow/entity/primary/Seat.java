package com.demo.bookmyshow.entity.primary;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Column(name = "is_booked",columnDefinition = "BOOLEAN")
    private Boolean isBooked;

    @Column(name = "availble_rows",columnDefinition = "INT")
    private Integer row;

    private String section;
    //gold,diamond,silver
    private String catagory;

    @ManyToMany(mappedBy = "seats")
    private List<Screen> screens;

    @ManyToMany(mappedBy = "seats")
    private List<Booking> bookings;

    private Double basePrice;
}
