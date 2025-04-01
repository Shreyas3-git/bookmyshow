package com.demo.bookmyshow.exceptionhandling;

import com.demo.bookmyshow.dto.CommonResponse;
import com.demo.bookmyshow.dto.response.ErrorCode;
import com.demo.bookmyshow.dto.response.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler
{

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse> handleInvocationTargetException(Exception ex) {
        String rootCause = ex.getLocalizedMessage();
        log.error("Invocation failed: {}", rootCause);
        ex.printStackTrace();
        return ResponseEntity.internalServerError()
            .body(CommonResponse.builder()
                .status(Status.FAILED.name())
                .errorCode(ErrorCode.INTERNAL_SERVER_ERROR.name())
                .message("Failed to process request: " + rootCause)
                .timestamp(LocalDateTime.now())
                .build());
    }
}
