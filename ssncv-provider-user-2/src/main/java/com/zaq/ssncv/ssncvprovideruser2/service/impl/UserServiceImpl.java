package com.zaq.ssncv.ssncvprovideruser2.service.impl;

import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvprovideruser2.dao.UserDao;
import com.zaq.ssncv.ssncvprovideruser2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZAQ
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(@Autowired UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(User user) {
        return userDao.selectByPhone(user.getPhone());
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int updateSelectively(User user) {
        return 0;
    }

    @Override
    public int register(User user) {
        return 0;
    }
}
