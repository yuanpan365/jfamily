package com.yuanpan.jfamily.security.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.exception
 * @Description: 不支持的方法验证 / GET != POST
 * @date 2018/6/7 14:01
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {
    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}
