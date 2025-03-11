package com.demo.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie
{
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @Column(name = "movie_id",columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "title",columnDefinition = "VARCHAR(100)")
    private String title;

    @Column(name = "genre",columnDefinition = "VARCHAR(50)")
    private String genre;

    @Column(name = "duration",columnDefinition = "TIMESTAMP")
    private LocalDateTime duration;

    @OneToMany(mappedBy = "star_cast_id",cascade = CascadeType.ALL)
    private List<StarCast> starCast;

    private String imdbRating;
}
