package com.zaq.ssncv.ssncvprovidernotification.mapper;

import com.zaq.ssncv.ssncvapi.entity.Notification;
import com.zaq.ssncv.ssncvapi.entity.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationMapper {
    int deleteById(int id);

    int insert(Notification notification);

    int insertSelectively(Notification notification);

    Notification selectById(Integer id);

    int updateByIdSelectively(Notification notification);

    int updateById(Notification notification);


    List<Notification> list(PageBean<Notification> pageBean);


    Notification selectLatest();
}
