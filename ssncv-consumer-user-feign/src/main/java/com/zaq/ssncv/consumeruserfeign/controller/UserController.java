package com.zaq.ssncv.consumeruserfeign.controller;

import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZAQ
 */
@RequestMapping("/consumer/user")
@RestController
public class UserController {

    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return userService.index();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<User> login(@RequestBody User user) {
        return userService.login(user);
    }

    @RequestMapping(value = "/logout")
    public Result<String> logout() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return userService.logout();
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<String> register(@RequestBody User user) {
        return userService.register(user);
    }
}
