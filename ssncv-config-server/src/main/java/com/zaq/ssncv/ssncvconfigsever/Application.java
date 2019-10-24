package com.zaq.ssncv.ssncvconfigsever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author ZAQ
 * 注解@EnableConfigServer 开启Spring Cloud Config 服务端功能
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
