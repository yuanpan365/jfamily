package com.yuanpan.jfamily.gateway.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.gateway.config
 * @Description: 生成对应的 RouteDefinition 数组
 * @date 2018/6/5 14:56
 */
//@Configuration
public class RouteDefinitionConfig {
    @Bean
    public DiscoveryClientRouteDefinitionLocator discoveryClientRouteLocator(DiscoveryClient discoveryClient,
                                                                             DiscoveryLocatorProperties properties) {
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
    }
}
