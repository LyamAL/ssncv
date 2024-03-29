package com.zaq.ssncv.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ZAQ
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerApp.class).run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EurekaServerApp.class);
    }
}
