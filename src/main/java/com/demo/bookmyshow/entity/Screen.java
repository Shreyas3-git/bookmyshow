package com.demo.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "screen")
@AllArgsConstructor
@NoArgsConstructor
public class Screen
{
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @Column(name = "screen_id",columnDefinition = "BIGINT")
    private Long id;

    private String name;

    private Integer capacity;

    private String rowCount;

    private String seatCountPerRow;

    private boolean isActive;

    private ScreenType screenType;

    @ManyToOne(targetEntity = Theather.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "theather_id")
    private Theather theather;

    @ManyToMany
    @JoinTable(name = "screen_seats",
        joinColumns = @JoinColumn(name = "screen_id"),
        inverseJoinColumns = @JoinColumn(name = "seat_id"))
    private List<Seat> seats;
}
