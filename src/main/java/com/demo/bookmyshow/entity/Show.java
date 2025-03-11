package com.demo.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "show")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show
{
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @Column(name = "booking_id",columnDefinition = "BIGINT")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @Column(name = "show_time",columnDefinition = "DATETIME")
    private LocalDateTime showTime;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Seat> seats;
}
