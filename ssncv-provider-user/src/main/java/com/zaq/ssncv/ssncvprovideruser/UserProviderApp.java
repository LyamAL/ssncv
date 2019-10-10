package com.zaq.ssncv.ssncvprovideruser;

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
@MapperScan("com.zaq.ssncv.ssncvprovideruser.mapper")
@EnableDiscoveryClient
public class UserProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderApp.class, args);
    }

}
