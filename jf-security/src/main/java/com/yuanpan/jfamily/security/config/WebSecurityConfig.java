package com.yuanpan.jfamily.security.config;

import com.yuanpan.jfamily.security.RestAuthenticationEntryPoint;
import com.yuanpan.jfamily.security.auth.login.LoginAuthenticationProvider;
import com.yuanpan.jfamily.security.auth.login.LoginProcessingFilter;
import com.yuanpan.jfamily.security.auth.token.SkipPathRequestMatcher;
import com.yuanpan.jfamily.security.auth.token.TokenAuthenticationProcessingFilter;
import com.yuanpan.jfamily.security.auth.token.TokenAuthenticationProvider;
import com.yuanpan.jfamily.security.auth.token.extractor.TokenExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.security.config
 * @Description: 通过 @EnableWebMvcSecurity 注解开启Spring Security的功能  ,继承 WebSecurityConfigurerAdapter ，并重写它的方法来设置一些web安全的细节
 * @date 2018/6/7 13:08
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String TOKEN_HEADER_PARAM = "X-Authorization";
    private static final String FORM_BASED_LOGIN_ENTRY_POINT = "/api/auth/login";
    private static final String TOKEN_BASED_AUTH_ENTRY_POINT = "/api/**";
    private static final String MANAGE_TOKEN_BASED_AUTH_ENTRY_POINT = "/manage/**";
    private static final String TOKEN_REFRESH_ENTRY_POINT = "/api/auth/refresh_token";

    private final RestAuthenticationEntryPoint authenticationEntryPoint;
    private final AuthenticationSuccessHandler successHandler;
    private final AuthenticationFailureHandler failureHandler;
    private final LoginAuthenticationProvider loginAuthenticationProvider;
    private final TokenAuthenticationProvider tokenAuthenticationProvider;
    private final TokenExtractor tokenExtractor;

    @Autowired
    public WebSecurityConfig(RestAuthenticationEntryPoint authenticationEntryPoint, AuthenticationSuccessHandler successHandler, AuthenticationFailureHandler failureHandler, LoginAuthenticationProvider loginAuthenticationProvider, TokenAuthenticationProvider tokenAuthenticationProvider, TokenExtractor tokenExtractor) {
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
        this.loginAuthenticationProvider = loginAuthenticationProvider;
        this.tokenAuthenticationProvider = tokenAuthenticationProvider;
        this.tokenExtractor = tokenExtractor;
    }

    private LoginProcessingFilter buildLoginProcessingFilter() throws Exception {
        LoginProcessingFilter filter = new LoginProcessingFilter(FORM_BASED_LOGIN_ENTRY_POINT, successHandler, failureHandler);
        filter.setAuthenticationManager(super.authenticationManager());
        return filter;
    }

    private TokenAuthenticationProcessingFilter buildTokenAuthenticationProcessingFilter() throws Exception {
        List<String> list =  new ArrayList<>();
        list.add(TOKEN_BASED_AUTH_ENTRY_POINT);
        list.add(MANAGE_TOKEN_BASED_AUTH_ENTRY_POINT);
        SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(list);
        TokenAuthenticationProcessingFilter filter = new TokenAuthenticationProcessingFilter(failureHandler, tokenExtractor, matcher);
        filter.setAuthenticationManager(super.authenticationManager());
        return filter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(loginAuthenticationProvider);
        auth.authenticationProvider(tokenAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // 因为使用的是JWT，因此这里可以关闭csrf了
                .exceptionHandling()
                .authenticationEntryPoint(this.authenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//无状态的Session机制
                .and()
                .authorizeRequests()
                .antMatchers(FORM_BASED_LOGIN_ENTRY_POINT).permitAll() // Login end-point
                .antMatchers(TOKEN_REFRESH_ENTRY_POINT).permitAll() // Token refresh end-point
                .and()
                .authorizeRequests()
                .antMatchers(TOKEN_BASED_AUTH_ENTRY_POINT).authenticated() // Protected API End-points
                .antMatchers(MANAGE_TOKEN_BASED_AUTH_ENTRY_POINT).hasAnyRole("admin")
                .and()
                .addFilterBefore(buildLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(buildTokenAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
