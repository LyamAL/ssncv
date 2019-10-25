package com.zaq.ssncv.ssncvconsumernotification.controller;

import com.zaq.ssncv.ssncvapi.entity.Notification;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZAQ
 */
@RequestMapping("/consumer/notification")
@RestController
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(@Autowired NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
    public Result<String> delete(@PathVariable("id") int id) {
        return notificationService.delete(id);
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public Result<String> saveOrUpdate(@RequestBody Notification notification) {
        return notificationService.saveOrUpdate(notification);
    }

    @RequestMapping(value = "/saveOrUpdateInit/{id}", method = RequestMethod.POST)
    public Result<Notification> saveOrUpdateInit(@PathVariable(required = false) int id) {
        return notificationService.saveOrUpdateInit(id);
    }

    @RequestMapping("/get/latest")
    public Result<Notification> getLatestNotification() {
        return notificationService.getLatestNotification();
    }
}
