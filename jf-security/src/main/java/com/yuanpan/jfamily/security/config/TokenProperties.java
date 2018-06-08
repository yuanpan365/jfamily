package com.yuanpan.jfamily.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.config
 * @Description: ${todo}
 * @date 2018/6/7 13:53
 */
@Configuration
@ConfigurationProperties(prefix = "jf.security.token")
public class TokenProperties {
    /**
     * token的过期时间
     */
    private Integer expirationTime;

    /**
     * 发行人
     */
    private String issuer;

    /**
     * 使用的签名KEY
     */
    private String signingKey;

    /**
     *  刷新过期时间
     */
    private Integer refreshExpTime;

    public Integer getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Integer expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getSigningKey() {
        return signingKey;
    }

    public void setSigningKey(String signingKey) {
        this.signingKey = signingKey;
    }

    public Integer getRefreshExpTime() {
        return refreshExpTime;
    }

    public void setRefreshExpTime(Integer refreshExpTime) {
        this.refreshExpTime = refreshExpTime;
    }

}
