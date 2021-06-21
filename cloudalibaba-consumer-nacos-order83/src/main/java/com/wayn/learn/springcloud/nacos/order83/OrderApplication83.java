package com.wayn.learn.springcloud.nacos.order83;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication83 {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication83.class, args);
    }
}
