package com.zaq.ssncv.ssncvprovidernotification.service.impl;

import com.zaq.ssncv.ssncvapi.entity.Notification;
import com.zaq.ssncv.ssncvapi.entity.PageBean;
import com.zaq.ssncv.ssncvprovidernotification.dao.NotificationDao;
import com.zaq.ssncv.ssncvprovidernotification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZAQ
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    public static final int SUCCESS = 1;
    public static final int ERROR = -1;
    private NotificationDao notificationDao;

    public NotificationServiceImpl(@Autowired NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    @Override
    public int delete(int id) {
        int status = notificationDao.delete(id);
        if (status > 0) {
            return SUCCESS;
        }
        return ERROR;
    }

    @Override
    public int saveOrUpdate(Notification notification) {
        int status = notificationDao.saveOrUpdate(notification);
        if (status > 0) {
            return SUCCESS;
        }
        return ERROR;
    }

    @Override
    public Notification selectById(Integer id) {
        return notificationDao.selectById(id);
    }

    @Override
    public PageBean<Notification> list(PageBean<Notification> pageBean) {
        return notificationDao.list(pageBean);
    }

    @Override
    public Notification selectLatest() {
        return null;
    }
}
