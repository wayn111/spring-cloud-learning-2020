package com.wayn.learn.springcloud.order84.service;

import com.wayn.learn.springcloud.commons.entity.CommonResult;
import com.wayn.learn.springcloud.commons.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackServe.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);


}
