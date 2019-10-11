package com.zaq.ssncv.ssncvconfigclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZAQ
 */
@RefreshScope
@RestController
public class TestController {
    private Environment env;

    public TestController(@Autowired Environment env) {
        this.env = env;
    }

    //    @Value("${from}")
//    private String from;
    @RequestMapping("/from")
    public String from() {
        return env.getProperty("from", "undefined");
    }
}

