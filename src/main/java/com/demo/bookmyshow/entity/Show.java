package com.demo.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shows")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show
{
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @Column(name = "show_id",columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "show_time",columnDefinition = "DATETIME")
    private LocalDateTime showTime;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movies;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @ManyToOne(targetEntity = Theather.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "theather_id")
    private Theather theather;

    @OneToMany(mappedBy = "shows",cascade = CascadeType.ALL)
    private List<Item> items;
}
