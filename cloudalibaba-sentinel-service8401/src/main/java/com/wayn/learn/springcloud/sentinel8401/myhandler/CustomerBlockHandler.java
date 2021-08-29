package com.wayn.learn.springcloud.sentinel8401.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wayn.learn.springcloud.commons.entity.CommonResult;

/**
 * 自定义异常，返回值需要相同，且方法是静态方法
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler..........1");

    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler..........2");

    }
}

