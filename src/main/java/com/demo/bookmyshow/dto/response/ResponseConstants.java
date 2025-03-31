package com.demo.bookmyshow.dto.response;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class ResponseConstants
{
    public static String SENDOTP_SUCCESS_MESSAGE = "OTP Send Successfully";
    public static String SENDOTP_FAILED_MESSAGE = "Failed to Send OTP";
    public static String INVALID_TOKEN = "Invalid Bearer Token";

    @PostConstruct
    public void logTwilioConfig() {
        System.out.println("SENDOTP_SUCCESS_MESSAGE: " + SENDOTP_SUCCESS_MESSAGE);
        System.out.println("SENDOTP_FAILED_MESSAGE: " + SENDOTP_FAILED_MESSAGE);
        System.out.println("INVALID_TOKEN: " + INVALID_TOKEN);
    }

}
