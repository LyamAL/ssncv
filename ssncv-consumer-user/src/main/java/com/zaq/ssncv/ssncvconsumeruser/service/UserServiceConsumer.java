package com.zaq.ssncv.ssncvconsumeruser.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZAQ
 */
@Service
public class UserServiceConsumer {
    private static final String REST_URL_PREFIX = "http://SSNCV-PROVIDER-USER";
    private RestTemplate restTemplate;

    public UserServiceConsumer(@Autowired RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "indexFallBack")
    public String index() {
        return restTemplate.getForEntity(REST_URL_PREFIX + "/user/index"
                , String.class).getBody();
    }

    public String indexFallBack() {
        return "error";
    }
}
