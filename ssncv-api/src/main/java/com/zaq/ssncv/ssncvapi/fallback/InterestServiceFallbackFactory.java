package com.zaq.ssncv.ssncvapi.fallback;


import com.zaq.ssncv.ssncvapi.entity.Interest;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.service.InterestService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ZAQ
 */
@Component
public class InterestServiceFallbackFactory implements FallbackFactory<InterestService> {
    @Override
    public InterestService create(Throwable throwable) {
        return new InterestServiceFallbackImpl();
    }

    static class InterestServiceFallbackImpl implements InterestService {
        @Override
        public Result<List<Interest>> listAll() {
            return new Result<List<Interest>>() {{
                setMsg("降级处理");
            }};
        }

        @Override
        public Result<Interest> get() {
            return new Result<>();
        }
    }
}

