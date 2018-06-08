package com.yuanpan.jfamily.security.model.token;

import com.yuanpan.jfamily.security.exception.ExpiredTokenException;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.BadCredentialsException;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.model.token
 * @Description: RawAccessToken
 * @date 2018/6/7 13:46
 */
public class RawAccessToken implements Token{

    private String token;

    public RawAccessToken(String token) {
        this.token = token;
    }

    /**
     * 分析并且验证Token是否有效
     *
     * @throws BadCredentialsException 如果验证请求被拒绝，则因为凭据无效 <br> 对于要抛出的异常，它意味着该帐户既不锁定也不禁用。 <br>
     * @throws ExpiredTokenException   过期的Token
     */
    public Jws<Claims> parseClaims(String signingKey) {
        try {
            return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(this.token);
        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
            throw new BadCredentialsException("Invalid token: ", ex);
        } catch (ExpiredJwtException expiredEx) {
            throw new ExpiredTokenException(this, "Token expired", expiredEx);
        }
    }

    @Override
    public String getToken() {
        return token;
    }
}
