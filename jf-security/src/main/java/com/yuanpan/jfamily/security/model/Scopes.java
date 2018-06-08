package com.yuanpan.jfamily.security.model;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.model
 * @Description: Scopes
 * @date 2018/6/7 13:35
 */
public enum Scopes {
    REFRESH_TOKEN;
    public String authority() {
        return "ROLE_" + this.name();
    }
}
