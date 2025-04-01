package com.demo.bookmyshow.controller;

import com.demo.bookmyshow.dto.CommonResponse;
import com.demo.bookmyshow.dto.pdf.CountryReq;
import com.demo.bookmyshow.dto.request.SendOtpRequest;
import com.demo.bookmyshow.dto.request.VerifyOtpRequest;
import com.demo.bookmyshow.dto.response.ErrorCode;
import com.demo.bookmyshow.dto.response.ResponseConstants;
import com.demo.bookmyshow.dto.response.Status;
import com.demo.bookmyshow.entity.secondary.User;
import com.demo.bookmyshow.repository.secondary.UserRepository;
import com.demo.bookmyshow.service.CustomerSendOtpService;
import com.demo.bookmyshow.service.CustomerVerifyOtpService;
import com.demo.bookmyshow.service.SendPDFAttachmentService;
import com.nimbusds.jose.shaded.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.function.Supplier;

@RestController
@RequestMapping("/bookmyshow/api")
public class BookMyShowController
{

    @Autowired
    private UserRepository userProfileRepository;

    @Autowired
    private CustomerSendOtpService customerSendOtpService;

    @Autowired
    private CustomerVerifyOtpService customerVerifyOtpService;

    @PostMapping("/shows")
    @PreAuthorize("hasRole('USER')")
    public String getShows(Authentication authentication) {
        String email = authentication.getName(); // Extracted from JWT
        System.out.println("customer email => "+email);
        userProfileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        return "List of available shows";
    }

    @GetMapping("/profile")
    @PreAuthorize("hasRole('USER')")
    public User getProfile(Authentication authentication) {
        String email = authentication.getName(); // Extracted from JWT
        return userProfileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    @PostMapping("/sendOtp")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<CommonResponse> sendOtp(Authentication authentication, @RequestBody SendOtpRequest request) {
        String email = authentication.getName();
        return userProfileRepository.findByEmail(email).map(user -> customerSendOtpService.sendOpt(request))
            .orElseGet(() -> new ResponseEntity<>(CommonResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(ResponseConstants.INVALID_TOKEN)
                .errorCode(ErrorCode.UNAUTHORIZED.name())
                .status(Status.FAILED.name())
                .build(),
                HttpStatus.UNAUTHORIZED));
    }

    @PostMapping("/verifyOtp")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<CommonResponse> verifyOtp(Authentication authentication, @RequestBody VerifyOtpRequest request) {
        String email = authentication.getName();
        return userProfileRepository.findByEmail(email).map(user -> customerVerifyOtpService.verifyOtp(request))
            .orElseGet(() -> new ResponseEntity<>(CommonResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(ResponseConstants.INVALID_TOKEN)
                .errorCode(ErrorCode.UNAUTHORIZED.name())
                .status(Status.FAILED.name())
                .build(),HttpStatus.UNAUTHORIZED));
    }
}
