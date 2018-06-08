package com.yuanpan.jfamily.security.model.token;

import io.jsonwebtoken.Claims;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.model.token
 * @Description: 验证Token
 * @date 2018/6/7 13:44
 */
public final class AccessToken implements Token {

    private final String rawToken;
    private Claims claims;

    protected AccessToken(final String token, Claims claims) {
        this.rawToken = token;
        this.claims = claims;
    }


    @Override
    public String getToken() {
        return this.rawToken;
    }

    public Claims getClaims() {
        return claims;
    }
}
