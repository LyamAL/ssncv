package com.zaq.ssncv.ssncvprovidernotification;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ZAQ
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("com.zaq.ssncv.ssncvprovidernotification.mapper")
public class NotificationProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(NotificationProviderApp.class, args);
    }

}
