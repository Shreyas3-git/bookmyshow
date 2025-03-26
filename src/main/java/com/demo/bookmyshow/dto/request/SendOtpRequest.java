package com.demo.bookmyshow.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendOtpRequest
{
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid phone number (10 digits required)")
    @NotNull(message = "phoneNumber should not be null")
    private String phoneNumber;
}
