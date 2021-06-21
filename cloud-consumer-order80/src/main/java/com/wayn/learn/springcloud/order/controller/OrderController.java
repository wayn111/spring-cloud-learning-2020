package com.wayn.learn.springcloud.order.controller;

import com.wayn.learn.springcloud.commons.entity.CommonResult;
import com.wayn.learn.springcloud.commons.entity.Payment;
import com.wayn.learn.springcloud.order.config.MyRoundLb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
public class OrderController {

    // 使用eureka指定的服务名进行负载均衡调用
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult get(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("consumer/payment/zipkin")
    public Object get() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
    }


    @Autowired
    private DiscoveryClient discoveryClient;


    @Autowired
    private MyRoundLb myRoundLb;

    /**
     * 自定义负载均衡算法
     *
     * @return CommonResult
     */
    @GetMapping("consumer/payment/lbCall")
    public CommonResult lbCall() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = myRoundLb.getInstance(instances);
        return restTemplate.getForObject(instance.getUri() + "/payment/lbGet", CommonResult.class);
    }
}
