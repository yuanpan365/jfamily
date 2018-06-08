package com.yuanpan.jfamily.security.auth.login;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.auth.login
 * @Description: 客户端登录认证模型
 * @date 2018/6/7 13:28
 */
public class LoginRequest {


    private String username;
    private String password;

    @JsonCreator
    public LoginRequest(@JsonProperty("username") String username, @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
