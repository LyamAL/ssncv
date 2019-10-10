package com.zaq.ssncv.ssncvapi.fallback;


import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.Surrounding;
import com.zaq.ssncv.ssncvapi.service.SurroundingService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ZAQ
 */
@Component
public class SurroundingServiceFallbackFactory implements FallbackFactory<SurroundingService> {
    @Override
    public SurroundingService create(Throwable throwable) {
        return new SurroundingServiceFallbackImpl();
    }

    static class SurroundingServiceFallbackImpl implements SurroundingService {
        @Override
        public Result<List<Surrounding>> listAll() {
            return new Result<List<Surrounding>>() {{
                setMsg("降级处理");
            }};
        }
    }
}

