package com.wayn.learn.springcloud.payment.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * payment
 * @author 
 */
@Data
public class Payment implements Serializable {
    private Long id;

    private String serial;

    private static final long serialVersionUID = 1L;
}