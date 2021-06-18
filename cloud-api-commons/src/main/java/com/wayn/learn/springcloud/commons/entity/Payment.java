package com.wayn.learn.springcloud.commons.entity;

import lombok.Data;

import java.io.Serializable;

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
