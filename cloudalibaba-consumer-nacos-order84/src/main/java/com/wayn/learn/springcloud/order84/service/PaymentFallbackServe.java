package com.wayn.learn.springcloud.order84.service;

import com.wayn.learn.springcloud.commons.entity.CommonResult;
import com.wayn.learn.springcloud.commons.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackServe implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
