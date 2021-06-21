package com.wayn.learn.springcloud.nacos.order83.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBlance {

    ServiceInstance getInstance(List<ServiceInstance> instances);
}
