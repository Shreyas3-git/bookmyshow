package com.demo.bookmyshow.entity.primary;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    // Helper method to add a screen
    public void addScreen(Screen screen) {
        if (screens == null) {
            screens = new ArrayList<>();
        }
        screens.add(screen);
        screen.setTheather(this);
    }

    // Helper method to add a show
    public void addShow(Show show) {
        if (shows == null) {
            shows = new ArrayList<>();
        }
        shows.add(show);
        show.setTheather(this);
    }

}
