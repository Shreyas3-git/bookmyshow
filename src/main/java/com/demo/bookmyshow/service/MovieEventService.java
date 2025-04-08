package com.demo.bookmyshow.service;

import com.demo.bookmyshow.dto.CommonResponse;
import com.demo.bookmyshow.dto.response.ErrorCode;
import com.demo.bookmyshow.dto.response.Status;
import com.demo.bookmyshow.entity.primary.Movie;
import com.demo.bookmyshow.entity.primary.Show;
import com.demo.bookmyshow.entity.primary.StarCast;
import com.demo.bookmyshow.repository.primary.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovieEventService
{
    @Autowired
    private MovieRepository movieRepository;

    @Transactional
    public ResponseEntity<CommonResponse> addMovieEvent(Movie movie) {
        if(movie.getStarCasts() != null) {
            for(StarCast starCast : movie.getStarCasts()) {
                starCast.getMovies().add(movie); // updated inversely to maintain data consistancy
            }
        }
        // Ensure Screen and Theather are linked properly
        if(movie.getShows() != null) {
            for(Show shows: movie.getShows()) {
                if(shows.getTheather() != null && shows.getScreen() != null) {
                    shows.getTheather().getScreens().add(shows.getScreen()); // Link Screen to Theather
                    shows.getScreen().setTheather(shows.getTheather()); // Update Screen inverse side
                }
            }
        }
        movieRepository.save(movie);
        return ResponseEntity.ok(CommonResponse.builder()
            .message("Movie Event Added Successfully")
            .status(Status.SUCCESS.name())
            .timestamp(LocalDateTime.now())
            .errorCode(ErrorCode.OK.name())
            .build());
    }
}
