package com.zaq.ssncv.ssncvapi.fallback;


import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.User;
import com.zaq.ssncv.ssncvapi.entity.UserOnModify;
import com.zaq.ssncv.ssncvapi.service.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        public Result<User> register(User user) {
            return new Result<>();

        }

        @Override
        public Result<String> logout() {
            return new Result<String>() {{
                setMsg("降级处理");
            }};
        }

        @Override
        public Result<List<User>> queryAll() {
            return new Result<List<User>>() {{
                setData(new ArrayList<>());
                setSuccess(false);
            }};
        }

        @Override
        public Result<String> update(UserOnModify user) {
            return new Result<String>() {{
                setMsg("降级处理");
            }};
        }
    }
}

