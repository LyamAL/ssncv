package com.zaq.ssncv.ssncvprovidercomment;

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
@MapperScan("com.zaq.ssncv.ssncvprovidercomment.mapper")
public class CommentProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(CommentProviderApp.class, args);
    }

}
