package com.zaq.ssncv.ssncvapi.fallback;

import com.zaq.ssncv.ssncvapi.entity.Notification;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.service.NotificationService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author ZAQ
 */
@Component
public class NotificationServiceFallbackFactory
        implements FallbackFactory<NotificationService> {
    @Override
    public NotificationService create(Throwable throwable) {
        return new NotificationServiceImpl();
    }

    static class NotificationServiceImpl implements NotificationService {
        @Override
        public Result<String> delete(int id) {
            return null;
        }

        @Override
        public Result<String> saveOrUpdate(Notification notification) {
            return null;
        }

        @Override
        public Result<Notification> saveOrUpdateInit(int id) {
            return null;
        }

        @Override
        public Result<Notification> getLatestNotification() {
            return null;
        }
    }
}

