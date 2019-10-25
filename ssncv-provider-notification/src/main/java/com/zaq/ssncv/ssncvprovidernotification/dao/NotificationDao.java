package com.zaq.ssncv.ssncvprovidernotification.dao;

import com.zaq.ssncv.ssncvapi.entity.Notification;

/**
 * @author ZAQ
 */
public interface NotificationDao {

    int delete(int id);

    int saveOrUpdate(Notification notification);

    Notification selectById(Integer id);

    Notification selectLatest();
}
