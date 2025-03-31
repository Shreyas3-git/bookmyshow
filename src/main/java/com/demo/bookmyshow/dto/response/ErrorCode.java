package com.demo.bookmyshow.dto.response;

public enum ErrorCode
{
    OK(200),
    BAD_REQUEST(400),
    UNEXPECTED_ERROR(500),
    DEPENDENCY_FAILED(424),
    CONFLICT(409),
    UNAUTHORIZED(401);

    private int errorCode;
    ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
