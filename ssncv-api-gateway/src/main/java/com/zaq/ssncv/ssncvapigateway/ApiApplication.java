package com.zaq.ssncv.ssncvapigateway;

import com.zaq.ssncv.ssncvapigateway.filter.AccessFilter;
import com.zaq.ssncv.ssncvapigateway.filter.ErrorFilter;
import com.zaq.ssncv.ssncvapigateway.filter.PostFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author ZAQ
 * 注解@EnableZuulProxy 开启API网关服务功能
 */
@SpringBootApplication
@EnableZuulProxy
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
}
