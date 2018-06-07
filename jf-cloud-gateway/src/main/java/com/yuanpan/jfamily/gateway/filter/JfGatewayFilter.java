package com.yuanpan.jfamily.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.gateway.filter
 * @Description: 网关过滤
 * @date 2018/6/514:27
 */
@Configuration
public class JfGatewayFilter implements GatewayFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("==");
        return chain.filter(exchange);
    }
}
