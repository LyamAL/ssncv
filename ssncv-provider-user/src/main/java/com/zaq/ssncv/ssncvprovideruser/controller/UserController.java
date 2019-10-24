package com.zaq.ssncv.ssncvprovideruser.controller;

import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvapi.entity.UserOnModify;
import com.zaq.ssncv.ssncvprovideruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZAQ
 */
@RestController
@RequestMapping("/user")
public class UserController {
    public static final int KEY_DUPLICATE_PHONE = -1;
    public static final int KEY_DUPLICATE_USERNAME = -2;
    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<User> register(@RequestBody User user) {
        return userService.register(user);
    }


    @RequestMapping("/index")
    public String index() {
        return "hello";
    }

    @RequestMapping(value = "/admin/query/{id}", method = RequestMethod.GET)
    public Result<User> query(@PathVariable(name = "id") int id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Result<String> updateAfterAuth(@RequestBody UserOnModify user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/admin/update/plain", method = RequestMethod.PUT)
    public Result<String> update(@RequestBody User user) {
        return userService.updateSelectively(user);
    }

    @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.DELETE)
    public Result<String> delete(@PathVariable int id) {
        return userService.delete(id);
    }

    @RequestMapping(value = "/admin/query/all", method = RequestMethod.GET)
    public Result<List<User>> queryAll() {
        return userService.queryAll();
    }

}
