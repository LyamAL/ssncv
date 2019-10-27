package com.zaq.ssncv.ssncveureka2;

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
public class EurekaServer2App extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EurekaServer2App.class);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServer2App.class).run(args);
    }
}
