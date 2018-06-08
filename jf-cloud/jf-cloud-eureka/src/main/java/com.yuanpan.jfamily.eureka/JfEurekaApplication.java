package com.yuanpan.jfamily.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.eureka
 * @Description: 服务注册中心
 * @date 2018/6/59:30
 */

@EnableEurekaServer
@SpringBootApplication
public class JfEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JfEurekaApplication.class, args);
        System.out.println("JfEurekaApplication start success");
    }
}
