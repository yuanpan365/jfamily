package com.yuanpan.jfamily.security.model;

import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.model
 * @Description: ${todo}
 * @date 2018/6/7 13:59
 */
public class ErrorResponse {

    // HTTP 相应状态码
    private final HttpStatus status;

    // 错误信息
    private final String message;

    // 错误码
    private final ErrorCode errorCode;

    private final Date timestamp;

    protected ErrorResponse(final String message, final ErrorCode errorCode, HttpStatus status) {
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
        this.timestamp = new Date();
    }

    public static ErrorResponse of(final String message, final ErrorCode errorCode, HttpStatus status) {
        return new ErrorResponse(message, errorCode, status);
    }

    public Integer getStatus() {
        return status.value();
    }

    public String getMessage() {
        return message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
