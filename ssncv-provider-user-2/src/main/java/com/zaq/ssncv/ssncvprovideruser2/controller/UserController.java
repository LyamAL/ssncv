package com.zaq.ssncv.ssncvprovideruser2.controller;


import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvprovideruser2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZAQ
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private DiscoveryClient client;
    private UserService userService;

    public UserController(@Autowired DiscoveryClient client, @Autowired UserService userService) {
        this.client = client;
        this.userService = userService;
    }

    //    public UserController(@Autowired UserService userService) {
//        this.userService = userService;
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result login(@RequestBody User user) {
        Result<User> result = new Result<>();
        user = userService.login(user);
        if (user.getId() > 0) {
            result.setMsg("success");
        } else {
            result.setMsg("fail");
        }
        result.setData(user);
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int register(@RequestBody User user) {
        System.out.println(user);
        return 1;
    }

    @RequestMapping("/index")
    public String index() {
        List<ServiceInstance> services = client.getInstances("ssncv-provider-user");
        for (ServiceInstance service : services) {
            System.out.println(service.getInstanceId() + "\t"
                    + service.getHost() + "\t" + service.getPort()
                    + "\t" + service.getUri());
        }
        return "hello";
    }


}
