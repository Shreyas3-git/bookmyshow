package com.demo.bookmyshow.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "theather")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Theather
{
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @Column(name = "theather_id",columnDefinition = "BIGINT")
    private Long id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<Screen> screens;

}
