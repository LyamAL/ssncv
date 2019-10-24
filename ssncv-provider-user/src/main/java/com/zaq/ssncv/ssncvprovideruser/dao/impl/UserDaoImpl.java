package com.zaq.ssncv.ssncvprovideruser.dao.impl;

import com.zaq.ssncv.ssncvapi.entity.Authority;
import com.zaq.ssncv.ssncvapi.entity.Role;
import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvapi.entity.UserOnModify;
import com.zaq.ssncv.ssncvprovideruser.dao.UserDao;
import com.zaq.ssncv.ssncvprovideruser.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public int insertRole(int uid) {
        Role role = new Role();
        role.setUid(uid);
        role.setAuthority(Authority.USER.toString());
        return userMapper.insertRole(role);
    }

    @Override
    public int insertSelectively(User user) {
        return userMapper.insertSelectively(user);
    }

    @Override
    public int delete(int id) {
        return userMapper.delete(id);
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
    public int update(UserOnModify user) {
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

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }
}
