package com.zaq.ssncv.ssncvprovideruser2.mapper;

import com.zaq.ssncv.ssncvapi.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    /**
     * 添加管理员
     *
     * @param admin
     * @return
     */
    int insert(Admin admin);

    /**
     * 删除管理员
     *
     * @param admin
     * @return
     */
    int delete(Admin admin);

    Admin select(String username);

    int update(Admin admin);

}
