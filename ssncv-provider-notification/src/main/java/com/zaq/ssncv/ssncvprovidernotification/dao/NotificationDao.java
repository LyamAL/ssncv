package com.zaq.ssncv.ssncvprovidernotification.dao;

import com.zaq.ssncv.ssncvapi.entity.Notification;
import com.zaq.ssncv.ssncvapi.entity.PageBean;

/**
 * @author ZAQ
 */
public interface NotificationDao {

    int delete(int id);

    int saveOrUpdate(Notification notification);

    Notification selectById(Integer id);

    PageBean<Notification> list(PageBean<Notification> pageBean);


    Notification selectLatest();
}
