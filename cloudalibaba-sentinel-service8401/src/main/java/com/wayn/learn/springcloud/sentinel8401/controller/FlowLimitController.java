package com.wayn.learn.springcloud.sentinel8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FlowLimitController {

    /**
     * qps限流
     *
     * @return
     */
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    /**
     * qps限流 warmup预热
     *
     * @return
     */
    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }

    /**
     * 线程数限流
     *
     * @return
     */
    @GetMapping("/testC")
    public String testC() throws InterruptedException {
        Thread.sleep(2000);
        return "------testC";
    }

    /**
     * testD-testE关联限流
     *
     * @return
     */
    @GetMapping("/testD")
    public String testD() {
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        return "------testE";
    }

    /**
     * testF排队限流
     *
     * @return
     */
    @GetMapping("/testF")
    public String testF() {
        log.info("------testF");
        return "------testF";
    }

    /**
     * testG 异常数熔断
     *
     * @return
     */
    @GetMapping("/testG")
    public String testG() {
        log.info("------testG");
        int i = 10 / 0;
        return "------testG";
    }

    /**
     * testH 降级RT
     *
     * @return
     */
    @GetMapping("/testH")
    public String testH() throws InterruptedException {
        Thread.sleep(1000);
        log.info("------testH RT");
        return "------testH RT";
    }

    /**
     * testI 降级异常比例
     *
     * @return
     */
    @GetMapping("/testI")
    public String testI() {
        log.info("------testI");
        int i = 10 / 0;
        return "------testI";
    }

    /**
     * 热点key限制
     *
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(
            @RequestParam(required = false) String p1,
            @RequestParam(required = false) String p2) {
        log.info("------testHotKey");
        // int i = 10 / 0;
        return "------testHotKey， p1:" + p1;
    }

    //兜底方法
    public String deal_testHotKey (String p1, String p2, BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o";
    }
}
