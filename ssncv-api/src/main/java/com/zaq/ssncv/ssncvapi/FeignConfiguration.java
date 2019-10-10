package com.zaq.ssncv.ssncvapi;

import feign.Feign;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author ZAQ
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public static Request.Options requestOptions(ConfigurableEnvironment env) {
        return new Request.Options(500000, 100000);
    }

    @Bean
    @Scope("prototype")
    public Feign.Builder feiBuilder() {
        return new Feign.Builder();
    }
}
