package com.zaq.ssncv.ssncvprovideruser.mapper;

import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvapi.entity.UserOnModify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
    int delete(int id);

    User selectById(int id);

    User selectByName(String username);

    int update(User user);

    /**
     * 修改用户资料，但需要通过旧信息的验证
     *
     * @param user
     * @return
     */
    int updateWhenPswMatches(UserOnModify user);

    int updateSelectively(User user);

    User selectByPhone(String user);

    /**
     * 获取对象
     *
     * @param id 主键
     * @return
     */
    User findById(int id);

    List<User> queryAll();
}
