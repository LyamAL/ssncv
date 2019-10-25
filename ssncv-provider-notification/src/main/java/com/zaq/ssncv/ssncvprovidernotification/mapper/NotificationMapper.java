package com.zaq.ssncv.ssncvprovidernotification.mapper;

import com.zaq.ssncv.ssncvapi.entity.Notification;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NotificationMapper {
    int deleteById(int id);

    int insert(Notification notification);

    int insertSelectively(Notification notification);

    Notification selectById(Integer id);

    int updateByIdSelectively(Notification notification);

    int updateById(Notification notification);

    Notification selectLatest();
}
