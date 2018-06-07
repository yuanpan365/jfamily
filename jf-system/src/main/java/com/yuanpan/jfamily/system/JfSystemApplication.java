package com.yuanpan.jfamily.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Yuan.pan
 * @Package com.yuanpan.jfamily.system
 * @Description: 后台管理
 * @date 2018/6/5 10:42
 */
@EnableEurekaClient
@SpringBootApplication
public class JfSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(JfSystemApplication.class, args);
        System.out.println("JfSystemApplication start success....");
    }
}
