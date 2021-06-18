package com.wayn.learn.springcloud.payment.service.impl;

import com.wayn.learn.springcloud.payment.dao.PaymentDao;
import com.wayn.learn.springcloud.payment.entity.Payment;
import com.wayn.learn.springcloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.selectByPrimaryKey(id);
    }
}
