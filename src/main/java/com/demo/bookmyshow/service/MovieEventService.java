package com.demo.bookmyshow.service;

import com.demo.bookmyshow.dto.CommonResponse;
import com.demo.bookmyshow.dto.response.ErrorCode;
import com.demo.bookmyshow.dto.response.Status;
import com.demo.bookmyshow.entity.primary.*;
import com.demo.bookmyshow.repository.primary.MovieRepository;
import com.demo.bookmyshow.repository.primary.ScreenRepository;
import com.demo.bookmyshow.repository.primary.TheatherRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieEventService
{
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatherRepository theatherRepository;

    @Autowired
    private ScreenRepository screenRepository;

    @Transactional(transactionManager = "db1TransactionManager")
    public ResponseEntity<CommonResponse> addMovieEvent(Movie movieEvent) {
        movieRepository.save(movieEvent);
        return ResponseEntity.ok(CommonResponse.builder()
            .message("Movie Event Added Successfully")
            .status(Status.SUCCESS.name())
            .timestamp(LocalDateTime.now())
            .errorCode(ErrorCode.OK.name())
            .build());
    }
}
