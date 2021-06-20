package com.wayn.learn.springcloud.stream.consumer8803.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 消费者
 */
@Component
@EnableBinding(Sink.class)
public class ConsumerController {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void receiver(Message<String> stringMessage) {
        System.out.println(port + "-消费者：" + stringMessage.getPayload());
    }
}
