package com.wayn.learn.springcloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OpenFeignApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication80.class, args);
    }
}
