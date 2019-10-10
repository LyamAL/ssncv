package com.zaq.ssncv.ssncvapi.fallback;


import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvapi.service.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author ZAQ
 */
@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserServiceFallbackImpl();
    }

    static class UserServiceFallbackImpl implements UserService {

        @Override
        public String index() {
            return "降级处理";
        }

        @Override
        public Result<User> login(User user) {
            return new Result<>();
        }

        @Override
        public Result<String> register(User user) {
            return new Result<String>() {{
                setMsg("降级处理");
            }};
        }

    }
}

