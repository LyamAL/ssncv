package com.zaq.ssncv.ssncvprovideruser.service;

import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvapi.entity.UserOnModify;

import java.util.List;

/**
 * @author ZAQ
 */
public interface UserService {
    User login(User user);

    int delete(int id);

    int update(User user);

    int updateAfterAuth(UserOnModify user);

    int updateSelectively(User user);

    int register(User user);


    User findById(int id);

    List<User> queryAll();

    String getMessage(int status);
}
