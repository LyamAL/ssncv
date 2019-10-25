package com.zaq.ssncv.ssncvprovidernotification.service;

import com.zaq.ssncv.ssncvapi.entity.Notification;
import com.zaq.ssncv.ssncvapi.entity.Result;

/**
 * @author ZAQ
 */
public interface NotificationService {
    Result<String> delete(int id);

    Result<String> saveOrUpdate(Notification notification);

    Result<Notification> selectById(Integer id);


    Result<Notification> selectLatest();
}
