package com.wayn.learn.springcloud.sentinel8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wayn.learn.springcloud.commons.entity.CommonResult;
import com.wayn.learn.springcloud.commons.entity.Payment;
import com.wayn.learn.springcloud.sentinel8401.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    /**
     * 根据资源名限流
     *
     * @return
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    /**
     * 根据url限流
     *
     * @return
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl", blockHandler = "urlException")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }

    /**
     * 自定义限流异常处理
     *
     * @return
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客戶自定义", new Payment(2020L, "serial003"));
    }

    public CommonResult urlException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t urlException");
    }
}
