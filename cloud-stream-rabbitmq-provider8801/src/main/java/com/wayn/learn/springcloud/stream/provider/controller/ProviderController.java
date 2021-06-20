package com.wayn.learn.springcloud.stream.provider.controller;

import com.wayn.learn.springcloud.stream.provider.service.ProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProviderController {

    @Resource
    private ProviderService providerService;

    @GetMapping("sendMessage")
    public String send() {
        boolean send = providerService.send();
        return "发送者：" + send;
    }
}
