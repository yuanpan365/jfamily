package com.yuanpan.jfamily.security.auth.token.verifier;

import org.springframework.stereotype.Component;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.auth.token.verifier
 * @Description:  Token验证过滤器
 * @date 2018/6/7 13:28
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
    @Override
    public boolean verify(String jti) {
        return true;
    }
}
