package com.zaq.ssncv.ssncveureka2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ZAQ
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer2App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer2App.class, args);
    }
}
