package com.yuanpan.jfamily.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.gateway
 * @Description: 网关配置
 * @date 2018/6/513:56
 */
@EnableDiscoveryClient
@SpringBootApplication
public class JfGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(JfGatewayApplication.class, args);
        System.out.println("JfGatewayApplication start success....");
    }
}
