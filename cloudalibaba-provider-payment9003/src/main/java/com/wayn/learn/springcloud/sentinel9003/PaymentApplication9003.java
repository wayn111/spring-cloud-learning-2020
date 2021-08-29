package com.wayn.learn.springcloud.sentinel9003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication9003 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9003.class, args);
    }
}
