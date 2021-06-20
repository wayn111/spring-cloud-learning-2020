package com.wayn.learn.springcloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

@Configuration
public class GatewayConfig {

    /**
     * 自定义网关配置
     *
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_baidu",
                r -> r.path("/guonei").uri("http://news.baidu.com")).build();
        return routes.build();
    }

    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now());
    }
}
