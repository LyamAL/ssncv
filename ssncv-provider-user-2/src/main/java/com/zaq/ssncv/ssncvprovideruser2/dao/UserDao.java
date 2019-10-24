package com.zaq.ssncv.ssncvprovideruser2.dao;

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

    int insertRole(int uid);

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


    int updateSelectively(User user);

    User selectByPhone(String phone);

    /**
     * 获取对象
     *
     * @param id 主键
     * @return
     */
    User findById(int id);

    int update(UserOnModify user);

    List<User> queryAll();

}
