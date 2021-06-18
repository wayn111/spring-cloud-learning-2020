package com.wayn.learn.springcloud.payment.dao;


import com.wayn.learn.springcloud.commons.entity.Payment;

public interface PaymentDao {
    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
}
