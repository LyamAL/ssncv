package com.zaq.ssncv.ssncvprovideruser2.service;


import com.zaq.ssncv.ssncvapi.entity.User;

public interface UserService {
    User login(User user);

    int delete(User user);

    int update(User user);

    int updateSelectively(User user);

    int register(User user);


}
