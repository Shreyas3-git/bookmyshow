package com.demo.bookmyshow.dto.response;

import lombok.Data;

@Data
public class SendCodeAttemptsItem
{
    private String attemptSid;
    private String channel;
    private String time;
}