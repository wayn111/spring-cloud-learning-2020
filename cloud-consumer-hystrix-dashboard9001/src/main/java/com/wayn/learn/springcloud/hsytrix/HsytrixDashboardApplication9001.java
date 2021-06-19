package com.wayn.learn.springcloud.hsytrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HsytrixDashboardApplication9001 {

    public static void main(String[] args) {
        SpringApplication.run(HsytrixDashboardApplication9001.class, args);
    }
}
