package com.zaq.ssncv.ssncvprovideruser.dao;


import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvapi.entity.UserOnModify;

import java.util.List;

/**
 * @author ZAQ
 */
public interface UserDao {
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int insert(User user);

    int insertSelectively(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int delete(int id);

    User selectById(int id);

    User selectByName(String username);

    int update(User user);

    int updateSelectively(User user);

    User selectByPhone(User user);

    /**
     * 获取对象
     *
     * @param id 主键
     * @return
     */
    User findById(int id);

    int updateAfterAuth(UserOnModify user);

    List<User> queryAll();
}