package com.wayn.learn.springcloud.payment.service;

import com.wayn.learn.springcloud.payment.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int create(Payment payment); //写

    Payment getPaymentById(@Param("id") Long id);  //读取
}
