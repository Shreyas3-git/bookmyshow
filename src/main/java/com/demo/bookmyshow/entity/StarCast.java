package com.demo.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "start_cast")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarCast
{
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @Column(name = "start_cast_id",columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "actor_name",columnDefinition = "VARCHAR(100)")
    private String actorName;

    @Column(name = "movie_name",columnDefinition = "VARCHAR(100)")
    private String movieName;

    @Column(name = "age",columnDefinition = "INT")
    private Integer age;

    @Column(name = "gender",columnDefinition = "VARCHAR(50)")
    private String gender;

    @Column(name = "dob",columnDefinition = "VARCHAR(50)")
    private String dob;
}
