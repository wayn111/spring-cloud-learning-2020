package com.wayn.learn.springcloud.order.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBlance {

    ServiceInstance getInstance(List<ServiceInstance> instances);
}
