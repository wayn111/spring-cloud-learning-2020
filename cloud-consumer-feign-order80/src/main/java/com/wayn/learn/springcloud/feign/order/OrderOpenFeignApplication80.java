package com.wayn.learn.springcloud.feign.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OrderOpenFeignApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignApplication80.class, args);
    }
}
