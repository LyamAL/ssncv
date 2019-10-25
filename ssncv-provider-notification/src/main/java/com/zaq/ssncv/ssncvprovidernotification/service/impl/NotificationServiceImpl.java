package com.zaq.ssncv.ssncvprovidernotification.service.impl;

import com.zaq.ssncv.ssncvapi.entity.Notification;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.service.BaseService;
import com.zaq.ssncv.ssncvprovidernotification.dao.NotificationDao;
import com.zaq.ssncv.ssncvprovidernotification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZAQ
 */
@Service
public class NotificationServiceImpl extends BaseService implements NotificationService {

    private NotificationDao notificationDao;

    public NotificationServiceImpl(@Autowired NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    @Override
    public Result<String> delete(int id) {
        Result<String> result = new Result<>();
        wrapResponse(result, notificationDao.delete(id));
        return result;
    }

    @Override
    public Result<String> saveOrUpdate(Notification notification) {
        Result<String> result = new Result<>();
        wrapResponse(result, notificationDao.saveOrUpdate(notification));
        return result;

    }

    @Override
    public Result<Notification> selectById(Integer id) {
        Result<Notification> result = new Result<>();
        wrapResponse(result, notificationDao.selectById(id));
        return result;
    }


    @Override
    public Result<Notification> selectLatest() {
        //TODO
        return null;
    }
}
