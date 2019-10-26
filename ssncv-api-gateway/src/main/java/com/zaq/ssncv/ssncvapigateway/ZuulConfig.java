package com.zaq.ssncv.ssncvapigateway;

import com.zaq.ssncv.ssncvapigateway.filter.AccessFilter;
import com.zaq.ssncv.ssncvapigateway.filter.ErrorFilter;
import com.zaq.ssncv.ssncvapigateway.filter.PostFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ZuulConfig {
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

    @Bean
    @Primary
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties getProperties() {
        return new ZuulProperties();
    }

}
