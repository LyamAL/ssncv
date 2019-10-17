package com.zaq.ssncv.ssncvprovidernotification.dao.impl;

import com.zaq.ssncv.ssncvapi.entity.Notification;
import com.zaq.ssncv.ssncvapi.entity.PageBean;
import com.zaq.ssncv.ssncvprovidernotification.dao.NotificationDao;
import com.zaq.ssncv.ssncvprovidernotification.mapper.NotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author ZAQ
 */
@Repository
public class NotificationDaoImpl implements NotificationDao {
    private NotificationMapper notificationMapper;

    public NotificationDaoImpl(@Autowired NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }


    @Override
    public int delete(int id) {
        return notificationMapper.deleteById(id);
    }

    @Override
    public int saveOrUpdate(Notification notification) {
        if (notification.getId() == null) {
            return notificationMapper.updateByIdSelectively(notification);
        } else {
            return notificationMapper.insertSelectively(notification);
        }
    }

    @Override
    public Notification selectById(Integer id) {
        if (id == null) {
            return new Notification();
        }
        return notificationMapper.selectById(id);
    }

    @Override
    public PageBean<Notification> list(PageBean<Notification> pageBean) {
        pageBean.setData(notificationMapper.list(pageBean));
        return pageBean;
    }

    @Override
    public Notification selectLatest() {
        return notificationMapper.selectLatest();
    }
}
