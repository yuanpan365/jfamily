package com.yuanpan.jfamily.security.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.model
 * @Description: 详细错误类型（枚举）.
 * @date 2018/6/7 13:59
 */
public enum ErrorCode {

    GLOBAL(2),

    AUTHENTICATION(10), JWT_TOKEN_EXPIRED(11);

    private int errorCode;

    private ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @JsonValue
    public int getErrorCode() {
        return errorCode;
    }
}
