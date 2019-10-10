package com.zaq.ssncv.ssncvprovideruser2.dao.impl;

import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvprovideruser2.dao.UserDao;
import com.zaq.ssncv.ssncvprovideruser2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author ZAQ
 */
@Repository
public class UserDaoImpl implements UserDao {
    private UserMapper userMapper;

    public UserDaoImpl(@Autowired UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int insertSelectively(User user) {
        return userMapper.insertSelectively(user);
    }

    @Override
    public int delete(User user) {
        return userMapper.delete(user);
    }

    @Override
    public User selectById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public User selectByName(String username) {
        return userMapper.selectByName(username);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int updateSelectively(User user) {
        return userMapper.updateSelectively(user);
    }

    @Override
    public User selectByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }
}
