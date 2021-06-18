package com.wayn.learn.springcloud.payment.controller;

import com.wayn.learn.springcloud.payment.entity.CommonResult;
import com.wayn.learn.springcloud.payment.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject("PAYMENT_URL" + "/payment/create", payment, CommonResult.class);
    }

}
