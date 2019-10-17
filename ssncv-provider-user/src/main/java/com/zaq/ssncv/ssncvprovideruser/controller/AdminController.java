package com.zaq.ssncv.ssncvprovideruser.controller;

import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvapi.entity.UserOnModify;
import com.zaq.ssncv.ssncvprovideruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZAQ
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    private static final String SUCCESS = "SUCCESS";
    private static final String BAD_CREDENTIAL = "wrong password";
    private UserService userService;

    public AdminController(@Autowired UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public Result<User> login(@RequestBody User user) {
//        Result<User> result = new Result<>();
//        user = userService.login(user);
//        if (isSuccess(user)) {
//            result.setSuccess(true);
//            result.setMsg(SUCCESS);
//            result.setData(user);
//        } else {
//            //密码错误
//            result.setData(new User());
//            result.setSuccess(false);
//            result.setMsg(BAD_CREDENTIAL);
//        }
//        return result;
//    }

    private boolean isSuccess(int status) {
        return status > 0;
    }

    private boolean isSuccess(Object obj) {
        return obj != null;
    }

    @RequestMapping("/index")
    public String index() {
        return "hello";
    }

    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public Result<User> query(@PathVariable(name = "id") int id) {
        Result<User> result = new Result<>();
        User user = userService.findById(id);
        if (isSuccess(user)) {
            result.setData(new User());
            result.setMsg("fail");
        } else {
            result.setData(user);
            result.setMsg("success");
        }
        return result;
    }

    @RequestMapping(value = "/update/auth", method = RequestMethod.PUT)
    public Result<String> updateWhenPswMatches(@RequestBody UserOnModify user) {
        Result<String> res = new Result<>();
        int status = userService.updateAfterAuth(user);
        if (isSuccess(status)) {
            res.setMsg(SUCCESS);
        } else {
            res.setData("原密码错误");
            res.setMsg("fail");
        }
        return res;
    }

    @RequestMapping(value = "/update/plain", method = RequestMethod.PUT)
    public Result<String> update(@RequestBody User user) {
        Result<String> res = new Result<>();
        int status = userService.updateSelectively(user);
        if (isSuccess(status)) {
            res.setMsg(SUCCESS);
        } else {
            res.setMsg("fail");
        }
        return res;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Result<String> delete(@PathVariable int id) {
        Result<String> res = new Result<>();
        int status = userService.delete(id);
        if (status > 0) {
            res.setMsg("success");
        } else {
            res.setMsg("fail");
        }
        return res;
    }

    @RequestMapping(value = "/query/all", method = RequestMethod.GET)
    public Result<List<User>> queryAll() {
        Result<List<User>> res = new Result<>();
        List<User> list = userService.queryAll();
        if (list == null) {
            res.setMsg("fail");
        } else {
            res.setMsg("success");
        }
        res.setData(list);
        return res;
    }


}
