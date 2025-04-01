package com.demo.bookmyshow.service;

import com.demo.bookmyshow.dto.CommonResponse;
import com.demo.bookmyshow.dto.request.SendOtpRequest;
import com.demo.bookmyshow.dto.response.ErrorCode;
import com.demo.bookmyshow.dto.response.ResponseConstants;
import com.demo.bookmyshow.dto.response.SendOtpResponse;
import com.demo.bookmyshow.dto.response.Status;
import com.demo.bookmyshow.entity.primary.Customer;
import com.demo.bookmyshow.feignconfig.NotificationClient;
import com.demo.bookmyshow.repository.primary.CustomerRepository;
import com.nimbusds.jose.shaded.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class CustomerSendOtpService
{
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private CustomerRepository customerRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ResponseEntity<CommonResponse> sendOpt(SendOtpRequest request) {
        ResponseEntity<String> responseBody = notificationService.twilioSendOtp(request);
        log.info("SendOtp Raw Response => {}",new Gson().toJson(responseBody));
        SendOtpResponse response = new Gson().fromJson(responseBody.getBody(), SendOtpResponse.class);
        if(responseBody.getStatusCode().is2xxSuccessful()) {
            String rrn = UUID.randomUUID() + "-" + System.currentTimeMillis();
            Customer customer = Customer.builder()
                    .rrn(rrn)
                    .phoneNumber(request.getPhoneNumber())
                    .referenceNumber(response.getSid())
                    .build();
            customerRepository.save(customer);
            return ResponseEntity.ok(CommonResponse.builder().rrn(rrn)
                .sid(response.getSid())
                .errorCode(ErrorCode.OK.name())
                .status(Status.SUCCESS.name())
                .message(ResponseConstants.SENDOTP_SUCCESS_MESSAGE)
                .timestamp(LocalDateTime.now())
                .build());
        } else {
            return ResponseEntity.ok(CommonResponse.builder()
                .sid(response.getSid())
                .errorCode(ErrorCode.BAD_REQUEST.name())
                .status(Status.FAILED.name())
                .message(ResponseConstants.SENDOTP_FAILED_MESSAGE)
                .timestamp(LocalDateTime.now())
                .build());
        }
    }

}
