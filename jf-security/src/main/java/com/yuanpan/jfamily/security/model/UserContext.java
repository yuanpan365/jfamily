package com.yuanpan.jfamily.security.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.model
 * @Description: ${todo}
 * @date 2018/6/7 13:42
 */
public class UserContext {

    private final String username;
    private final List<GrantedAuthority> authorities;

    private UserContext(String username, List<GrantedAuthority> authorities) {
        this.username = username;
        this.authorities = authorities;
    }

    public static UserContext create(String username, List<GrantedAuthority> authorities) {
        //if (StringUtils.isBlank(username)) throw new IllegalArgumentException("Username is blank: " + username);
        return new UserContext(username, authorities);
    }

    public String getUsername() {
        return username;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
