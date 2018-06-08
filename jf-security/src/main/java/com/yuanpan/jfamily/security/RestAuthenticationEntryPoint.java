package com.yuanpan.jfamily.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security
 * @Description: 自定义AuthenticationEntryPoint 默认情况下登陆失败返回信息
 * @date 2018/6/7 13:00
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value(), "Unauthorized");
    }
}
