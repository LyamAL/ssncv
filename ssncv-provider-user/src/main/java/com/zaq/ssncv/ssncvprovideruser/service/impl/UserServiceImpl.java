package com.zaq.ssncv.ssncvprovideruser.service.impl;

import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvapi.entity.UserOnModify;
import com.zaq.ssncv.ssncvprovideruser.dao.UserDao;
import com.zaq.ssncv.ssncvprovideruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.zaq.ssncv.ssncvprovideruser.controller.UserController.KEY_DUPLICATE_PHONE;
import static com.zaq.ssncv.ssncvprovideruser.controller.UserController.KEY_DUPLICATE_USERNAME;

/**
 * @author ZAQ
 */
@Service
public class UserServiceImpl implements UserService {

    private static final String CONSTRAINT_UNIQUE_KEY_PHONE = "user_phone_uindex";
    private static final String CONSTRAINT_UNIQUE_KEY_USERNAME = "user_username_uindex";

    private static final String VALUE_DUPLICATE_PHONE = "duplicate phone";
    private static final String VALUE_DUPLICATE_USERNAME = "duplicate username";
    private static final String VALUE_UNKNOWN_CUASE = "unknown failure";

    private UserDao userDao;

    public UserServiceImpl(@Autowired UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(User user) {
        return userDao.selectByPhone(user);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int updateAfterAuth(UserOnModify user) {
        return userDao.updateAfterAuth(user);
    }

    @Override
    public int updateSelectively(User user) {
        return userDao.updateSelectively(user);
    }

    @Override
    @Transactional(rollbackFor = DuplicateKeyException.class)
    public int register(User user) {
        int res = 0;
        try {
            res = userDao.insert(user);
        } catch (DuplicateKeyException e) {
            if (e.getMessage().contains(CONSTRAINT_UNIQUE_KEY_PHONE)) {
                return KEY_DUPLICATE_PHONE;
            }
            if (e.getMessage().contains(CONSTRAINT_UNIQUE_KEY_USERNAME)) {
                return KEY_DUPLICATE_USERNAME;
            }
        }
        return res;
    }


    @Override
    public String getMessage(int status) {
        switch (status) {
            case KEY_DUPLICATE_PHONE:
                return VALUE_DUPLICATE_PHONE;
            case KEY_DUPLICATE_USERNAME:
                return VALUE_DUPLICATE_USERNAME;
            default:
                return VALUE_UNKNOWN_CUASE;
        }
    }


    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }
}
