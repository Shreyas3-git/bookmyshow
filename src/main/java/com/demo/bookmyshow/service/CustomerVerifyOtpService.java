package com.demo.bookmyshow.service;

import com.demo.bookmyshow.dto.CommonResponse;
import com.demo.bookmyshow.dto.request.VerifyOtpRequest;
import com.demo.bookmyshow.dto.response.ErrorCode;
import com.demo.bookmyshow.dto.response.ResponseConstants;
import com.demo.bookmyshow.dto.response.Status;
import com.demo.bookmyshow.dto.response.VerifyOtpResponse;
import com.demo.bookmyshow.repository.primary.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.TaskExecutionOutcome;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerVerifyOtpService
{
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private CustomerRepository customerRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ResponseEntity<CommonResponse> verifyOtp(VerifyOtpRequest request) {
        return customerRepository.findByRrnAndReferenceNumber(request.getRrn(), request.getSid())
                .map(customer -> {
                    ResponseEntity<String> responseBody = notificationService.twilioVerifyOtp(request, customer.getPhoneNumber());
                    log.info(String.format("VerifyOtp Response: %s",responseBody));
                    if (responseBody.getStatusCode().is2xxSuccessful()) {
                        customer.setPhoneNumberVerified(true);
                        customer.setUpdatedAt(LocalDateTime.now());
                        customer.setStatus("completed");
                        customerRepository.save(customer);
                        return ResponseEntity.ok(CommonResponse.builder()
                            .message(ResponseConstants.VERIFYOTP_SUCCESS_MESSAGE)
                            .status(Status.SUCCESS.name())
                            .errorCode(ErrorCode.OK.name())
                            .timestamp(LocalDateTime.now())
                            .build());
                    } else {
                        return new ResponseEntity<>((CommonResponse.builder()
                            .message(ResponseConstants.VERIFYOTP_SUCCESS_MESSAGE)
                            .status(Status.FAILED.name())
                            .errorCode(ErrorCode.BAD_REQUEST.name())
                            .timestamp(LocalDateTime.now())
                            .build()), HttpStatus.BAD_REQUEST);
                    }
                })
                .orElseGet(() -> {
                    return new ResponseEntity<>((CommonResponse.builder()
                        .message(ResponseConstants.INVALID_RRN_OR_REFERENCENUMBER)
                        .status(Status.FAILED.name())
                        .errorCode(ErrorCode.BAD_REQUEST.name())
                        .timestamp(LocalDateTime.now())
                        .build()), HttpStatus.BAD_REQUEST);
                });
    }
}
