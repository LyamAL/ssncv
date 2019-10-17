package com.zaq.ssncv.ssncvprovidernotification.controller;

import com.zaq.ssncv.ssncvapi.entity.Notification;
import com.zaq.ssncv.ssncvapi.entity.PageBean;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvprovidernotification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import static com.zaq.ssncv.ssncvprovidernotification.service.impl.NotificationServiceImpl.SUCCESS;

/**
 * @author ZAQ
 */
@RestController
@RequestMapping("/notification")
public class NotificationController {
    private static final String MSG_ERROR = "数据库查询错误";
    private static final String MSG_SUCCESS = "success";
    private NotificationService notificationService;

    public NotificationController(@Autowired NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RequestMapping("/list/all")
    public Result<PageBean<Notification>> list(@Nullable @RequestBody Notification notification) {
        PageBean<Notification> pageBean = new PageBean<>();
        Result<PageBean<Notification>> result = new Result<>();
        if (notification != null) {
            pageBean.setParameter(notification);
            result.setMsg("success");
            result.setSuccess(true);
        } else {
            result.setMsg("null");
            result.setSuccess(false);
            pageBean.setParameter(new Notification());
        }
        return result;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
    public Result<String> delete(@PathVariable("id") int id) {
        Result<String> res = new Result<>();
        if (notificationService.delete(id) == SUCCESS) {
            res.setMsg(MSG_SUCCESS);
            res.setSuccess(true);
        } else {
            res.setMsg(MSG_ERROR);
            res.setSuccess(false);
        }
        return res;
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public Result<String> saveOrUpdate(@RequestBody Notification notification) {
        Result<String> res = new Result<>();
        if (notificationService.saveOrUpdate(notification) == SUCCESS) {
            res.setMsg(MSG_SUCCESS);
            res.setSuccess(true);
        } else {
            res.setMsg(MSG_ERROR);
            res.setSuccess(false);
        }
        return res;
    }

    @RequestMapping(value = "/saveOrUpdateInit/{id}", method = RequestMethod.POST)
    public Result<Notification> saveOrUpdateInit(@PathVariable(required = false) int id) {
        Result<Notification> res = new Result<>();
        Notification notification;
        if ((notification = notificationService.selectById(id)) != null) {
            res.setData(notification);
            res.setMsg(MSG_SUCCESS);
            res.setSuccess(true);
        } else {
            res.setData(new Notification());
            res.setMsg(MSG_ERROR);
            res.setSuccess(false);
        }
        return res;
    }

    @RequestMapping("/get/latest")
    public Result<Notification> getLatestNotification() {
        Result<Notification> res = new Result<>();
        Notification notification;
        if ((notification = notificationService.selectLatest()) != null) {
            res.setData(notification);
            res.setMsg(MSG_SUCCESS);
            res.setSuccess(true);
        } else {
            res.setData(new Notification());
            res.setMsg(MSG_ERROR);
            res.setSuccess(false);
        }
        return res;
    }

}
