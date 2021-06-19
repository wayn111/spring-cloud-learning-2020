package com.wayn.learn.springcloud.feign.controller;

import com.wayn.learn.springcloud.commons.entity.CommonResult;
import com.wayn.learn.springcloud.feign.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult get(@PathVariable Long id) {
        return paymentFeignService.getPaymentById(id);
    }

}

