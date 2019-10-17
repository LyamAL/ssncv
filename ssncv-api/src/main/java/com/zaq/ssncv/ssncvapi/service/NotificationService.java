package com.zaq.ssncv.ssncvapi.service;

import com.zaq.ssncv.ssncvapi.FeignConfiguration;
import com.zaq.ssncv.ssncvapi.entity.Notification;
import com.zaq.ssncv.ssncvapi.entity.PageBean;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.fallback.NotificationServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ZAQ
 */
@FeignClient(value = "SSNCV-PROVIDER-NOTIFICATION", configuration = FeignConfiguration.class,
        fallbackFactory = NotificationServiceFallbackFactory.class)
@RequestMapping("/notification")
public interface NotificationService {
    @RequestMapping("/list/all")
    Result<PageBean<Notification>> list(@RequestBody @Nullable Notification notification);

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
    Result<String> delete(@PathVariable("id") int id);

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    Result<String> saveOrUpdate(@RequestBody Notification notification);

    @RequestMapping(value = "/saveOrUpdateInit/{id}", method = RequestMethod.POST)
    Result<Notification> saveOrUpdateInit(@PathVariable(required = false) int id);

    @RequestMapping("/get/latest")
    Result<Notification> getLatestNotification();

}
