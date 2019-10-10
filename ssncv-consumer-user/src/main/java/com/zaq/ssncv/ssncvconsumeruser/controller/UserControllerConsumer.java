package com.zaq.ssncv.ssncvconsumeruser.controller;

import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvapi.entity.UserOnModify;
import com.zaq.ssncv.ssncvconsumeruser.service.UserServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZAQ
 */
@RequestMapping("/consumer/user")
@RestController
public class UserControllerConsumer {
    private static final String REST_URL_PREFIX = "http://SSNCV-PROVIDER-USER";
    private UserServiceConsumer userService;

//    private static final String REST_URL_PREFIX = "http://192.168.0.5:8002";
    /**
     * Restful服务模板类
     */
    private RestTemplate restTemplate;

    public UserControllerConsumer(@Autowired UserServiceConsumer userService, @Autowired RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/login")
    public Result login(@RequestBody User user) {
        return restTemplate.postForObject(
                REST_URL_PREFIX + "/user/login"
                , user
                , Result.class);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody User user) {
        return restTemplate.postForObject(
                REST_URL_PREFIX + "/user/add"
                , user
                , Result.class);
    }

    @RequestMapping("/index")
    public String index() {
        return userService.index();
    }

    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public ResponseEntity<Result> query(@PathVariable(name = "id") int id) {
        return restTemplate.getForEntity(REST_URL_PREFIX + "/user/query/{id}"
                , Result.class
                , id);
    }

    @RequestMapping(value = "/update/auth", method = RequestMethod.PUT)
    public void updateAfterAuth(@RequestBody UserOnModify user) {
        restTemplate.put(REST_URL_PREFIX + "/user/update/auth"
                , user);
    }

    @RequestMapping(value = "/update/plain", method = RequestMethod.PUT)
    public void update(@RequestBody User user) {
        restTemplate.put(REST_URL_PREFIX + "/user/update/plain"
                , user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        restTemplate.delete(REST_URL_PREFIX + "/delete/{id}", id);
    }


    @RequestMapping(value = "/query/all", method = RequestMethod.GET)
    public ResponseEntity<Result> queryAll() {
        return restTemplate.getForEntity(REST_URL_PREFIX + "/query/all", Result.class);
    }

}
