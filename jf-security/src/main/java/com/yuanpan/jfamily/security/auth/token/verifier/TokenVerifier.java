package com.yuanpan.jfamily.security.auth.token.verifier;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.auth.token.verifier
 * @Description:  Token验证
 * @date 2018/6/7 13:28
 */
public interface TokenVerifier {
    boolean verify(String jti);
}
