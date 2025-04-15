package com.demo.bookmyshow.dto.request;

import com.demo.bookmyshow.entity.primary.Show;
import com.demo.bookmyshow.entity.primary.StarCast;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
public class EventRequest
{
    @NotNull(message = "movie title Should not br null")
    @NotBlank(message = "movie title Should not br blank")
    private String title;

    @NotNull(message = "genre Should not br null")
    @NotBlank(message = "genre Should not br blank")
    private String genre;

    @NotNull(message = "movie duration Should not br null")
    @NotBlank(message = "movie duration Should not br blank")
    private LocalDateTime duration;

    @NotNull(message = "imdbRating Should not br null")
    @NotBlank(message = "imdbRating Should not br blank")
    private String imdbRating;

    @NotNull(message = "Shows list should not be null")
    @Size(min = 1, message = "Shows list should not be empty")
    private List<Show> shows;

    @NotNull(message = "starCasts list should not be null")
    @Size(min = 1, message = "starCasts list should not be empty")
    private List<StarCast> starCasts;

}
