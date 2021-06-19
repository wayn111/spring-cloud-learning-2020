package com.wayn.learn.springcloud.order.config;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义轮询负载均衡算法
 */
@Slf4j
@Component
public class MyRoundLb implements LoadBlance {

    private final AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> instances) {
        if (CollectionUtil.isEmpty(instances)) {
            log.warn("服务实例集合为空！");
            return null;
        }
        return instances.get(compareAndSet() % instances.size());
    }

    private int compareAndSet() {
        int current, next, retryCount = 100;
        current = atomicInteger.get();
        if (current >= Integer.MAX_VALUE) {
            current = 0;
        }
        next = current + 1;
        int count = 0;
        while (!atomicInteger.compareAndSet(current, next)) {
            count++;
            if (count >= retryCount) {
                log.warn("原子比较超过" + retryCount + "次，未能设置成功~");
                return current;
            }
        }
        return next;
    }
}
