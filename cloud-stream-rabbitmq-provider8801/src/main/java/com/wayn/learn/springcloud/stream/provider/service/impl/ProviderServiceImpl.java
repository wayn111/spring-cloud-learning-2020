package com.wayn.learn.springcloud.stream.provider.service.impl;

import cn.hutool.core.util.IdUtil;
import com.wayn.learn.springcloud.stream.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.xml.transform.Source;

@EnableBinding(Source.class)
@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private MessageChannel messageChannel;

    @Override
    public void send() {
        String payload = IdUtil.fastSimpleUUID();
        messageChannel.send(MessageBuilder.withPayload(payload).build());
        System.out.println("serial:" + payload);
    }
}
