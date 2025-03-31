package com.demo.bookmyshow.entity.primary;


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

    @OneToMany(mappedBy = "theather",cascade = CascadeType.ALL)
    private List<Screen> screens;

    @OneToMany(mappedBy = "theather",cascade = CascadeType.ALL)
    private List<Show> shows;

}
