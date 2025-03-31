package com.demo.bookmyshow.dto.response;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResponseConstants
{
    @Value("sendotp.success-message")
    public static String SENDOTP_SUCCESS_MESSAGE;

    @Value("sendotp.failure-message")
    public static String SENDOTP_FAILED_MESSAGE;

    @Value("${validation.token-failure}")
    public static String INVALID_TOKEN;
}
