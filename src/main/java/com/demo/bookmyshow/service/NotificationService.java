package com.demo.bookmyshow.service;

import com.demo.bookmyshow.dto.request.SendOtpRequest;
import com.demo.bookmyshow.dto.request.VerifyOtpRequest;
import com.demo.bookmyshow.feignconfig.NotificationClient;
import com.nimbusds.jose.shaded.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Service
public class NotificationService
{
    @Autowired
    private NotificationClient notificationClient;

    @Value("${app.notifications.twilio.account-sid}")
    private String accountSid;
    @Value("${app.notifications.twilio.service-sid}")
    private String serviceSid;
    @Value("${app.notifications.twilio.auth-token}")
    private String authToken;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public ResponseEntity<String> twilioSendOtp(SendOtpRequest request) {
        String phoneNum = formatToE164(request.getPhoneNumber());
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","application/x-www-form-urlencoded");
        String auth = getBasicAuthHeader.get();
        headers.put("Authorization",auth);
        String encodedTo = URLEncoder.encode(phoneNum, StandardCharsets.UTF_8);
        String requestBody = "To=" + encodedTo + "&Channel=sms";
        log.info(String.format("OtpRequest : %s and Request Header : %s", new Gson().toJson(requestBody), headers));
        return notificationClient.sendOtp(serviceSid,headers,requestBody);
    }


    private final Supplier<String> getBasicAuthHeader = () -> {
        String credentials = accountSid + ":" + authToken;
        return "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());

    };

    private String formatToE164(String phoneNumber) {
        String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");
        return "+91" + digitsOnly;
    }

    public ResponseEntity<String> twilioVerifyOtp(VerifyOtpRequest request,String phoneNumber) {
        String phoneNum = formatToE164(phoneNumber);
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","application/x-www-form-urlencoded");
        headers.put("Authorization",getBasicAuthHeader.get());
        String encodedPhoneNum = URLEncoder.encode(phoneNum,StandardCharsets.UTF_8);
        String encodedOtp = URLEncoder.encode(request.getOtp(),StandardCharsets.UTF_8);
        String requestBody = "Code=" + encodedOtp + "&To=" + encodedPhoneNum;
        log.info(String.format("VerifyOtp Request : %s and Request Header : %s",requestBody,headers));
        return notificationClient.verifyOtp(serviceSid,headers,requestBody);
    }
}
