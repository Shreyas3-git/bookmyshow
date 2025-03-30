package com.demo.bookmyshow.dto.response;


import org.springframework.beans.factory.annotation.Value;

public class ResponseConstants
{
    @Value("sendotp.success-message")
    private static String SUCCESS_MESSAGE;

    private static String SUCCESS_ERROR_CODE;
}
