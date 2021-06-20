package com.wayn.learn.springcloud.stream.provider.controller;

import com.wayn.learn.springcloud.stream.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("sendMessage")
    public String send() {
        providerService.send();
        return "发送成功！";
    }
}
