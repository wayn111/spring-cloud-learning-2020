package com.wayn.learn.springcloud.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡算法
 */
@Configuration
public class MyRuleConfig {

    /**
     * 使用随机算法
     *
     * @return IRule
     */
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
