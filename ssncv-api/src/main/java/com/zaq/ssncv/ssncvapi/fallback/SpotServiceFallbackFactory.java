package com.zaq.ssncv.ssncvapi.fallback;

import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.Spot;
import com.zaq.ssncv.ssncvapi.service.SpotService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ZAQ
 */
@Component
public class SpotServiceFallbackFactory implements FallbackFactory<SpotService> {
    @Override
    public SpotService create(Throwable throwable) {
        return new SpotServiceFallbackImpl();
    }

    static class SpotServiceFallbackImpl implements SpotService {
        @Override
        public Result<List<Spot>> listAll(int start, int limit) {
            return new Result<List<Spot>>() {{
                setMsg("降级处理");
            }};
        }

        @Override
        public Result<List<Spot>> matchName(String name, int start, int limit) {
            Result<List<Spot>> result = new Result<>();
            result.setMsg("降级处理");
            return result;
        }
    }
}

