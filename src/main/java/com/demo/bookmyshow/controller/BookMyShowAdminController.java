package com.demo.bookmyshow.controller;

import com.demo.bookmyshow.dto.CommonResponse;
import com.demo.bookmyshow.entity.primary.Movie;
import com.demo.bookmyshow.service.MovieEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookmyshow/admin")
public class BookMyShowAdminController
{

    @Autowired
    private MovieEventService movieEventService;

    @PostMapping("/createEvent")
    public ResponseEntity<CommonResponse> createMovieEvent(@RequestBody Movie movie) {
        return movieEventService.addMovieEvent(movie);
    }

}
