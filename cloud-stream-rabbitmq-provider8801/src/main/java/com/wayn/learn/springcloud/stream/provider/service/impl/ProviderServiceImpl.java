package com.wayn.learn.springcloud.stream.provider.service.impl;

import cn.hutool.core.util.IdUtil;
import com.wayn.learn.springcloud.stream.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Source.class)
public class ProviderServiceImpl implements ProviderService {

    //消息发送管道
    @Autowired
    private MessageChannel output;

    @Override
    public boolean send() {
        String payload = IdUtil.fastSimpleUUID();
        System.out.println("serial:" + payload);
        return output.send(MessageBuilder.withPayload(payload).build());
    }
}
