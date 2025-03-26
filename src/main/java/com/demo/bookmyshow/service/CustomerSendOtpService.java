package com.demo.bookmyshow.service;

import com.demo.bookmyshow.dto.CommonResponse;
import com.demo.bookmyshow.dto.request.SendOtpRequest;
import com.demo.bookmyshow.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerSendOtpService
{
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private CustomerRepository customerRepository;


    public ResponseEntity<CommonResponse> sendOpt(SendOtpRequest request) {
        return ResponseEntity.ok(CommonResponse.builder().build());
    }
}
