package com.demo.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theather_id")
    private Theather theather;

    private boolean isActive;

    private ScreenType screenType;


}
