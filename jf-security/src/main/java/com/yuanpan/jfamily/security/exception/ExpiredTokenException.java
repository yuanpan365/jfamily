package com.yuanpan.jfamily.security.exception;

import com.yuanpan.jfamily.security.model.token.Token;
import org.springframework.security.core.AuthenticationException;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.exception
 * @Description: 过期的Token
 * @date 2018/6/7 13:48
 */
public class ExpiredTokenException extends AuthenticationException {

    private Token token;

    public ExpiredTokenException(String msg) {
        super(msg);
    }

    public ExpiredTokenException(Token token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String token() {
        return this.token.getToken();
    }
}
