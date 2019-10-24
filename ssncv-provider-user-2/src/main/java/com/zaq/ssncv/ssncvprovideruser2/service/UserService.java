package com.zaq.ssncv.ssncvprovideruser2.service;

import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvapi.entity.UserOnModify;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author ZAQ
 */
public interface UserService extends UserDetailsService {
    Result<String> delete(int id);

    Result<String> update(UserOnModify user);

    Result<String> updateSelectively(User user);

    Result<User> register(User user);


    Result<User> findById(int id);

    Result<List<User>> queryAll();


}
