package com.demo.bookmyshow.dto.response;


import org.springframework.beans.factory.annotation.Value;

public class ResponseConstants
{
    @Value("sendotp.success-message")
    public static String SENDOTP_SUCCESS_MESSAGE;

    @Value("sendotp.failure-message")
    public static String SENDOTP_FAILED_MESSAGE;
}
