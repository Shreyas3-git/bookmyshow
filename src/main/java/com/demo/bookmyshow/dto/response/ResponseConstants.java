package com.demo.bookmyshow.dto.response;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class ResponseConstants
{
    public static String SENDOTP_SUCCESS_MESSAGE = "OTP Send Successfully";
    public static String SENDOTP_FAILED_MESSAGE = "Failed to Send OTP";
    public static String INVALID_TOKEN = "Invalid Bearer Token";
    public static String VERIFYOTP_SUCCESS_MESSAGE = "OTP Verified Successfully";
    public static String VERIFYOTP_FAILED_MESSAGE = "Failed to Verify OTP at this movement, Please try again after sometime";

    public static String INVALID_RRN_OR_REFERENCENUMBER = "Invalid RRN or Reference Number";

    public static String RestrictRequest = "Entered RRN is invalid";
}
