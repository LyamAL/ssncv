package com.zaq.ssncv.ssncvprovideruser2.mapper;

import com.zaq.ssncv.ssncvapi.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
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
     * @param user
     * @return
     */
    int delete(User user);

    User selectById(int id);

    User selectByName(String username);

    int update(User user);

    int updateSelectively(User user);

    User selectByPhone(String phone);
}
