package com.zaq.ssncv.ssncvapi.fallback;


import com.zaq.ssncv.ssncvapi.entity.Comment;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.service.CommentService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ZAQ
 */
@Component
public class CommentServiceFallbackFactory implements FallbackFactory<CommentService> {
    @Override
    public CommentService create(Throwable throwable) {
        return new CommentServiceFallbackImpl();
    }

    static class CommentServiceFallbackImpl implements CommentService {

        @Override
        public Result<List<Comment>> listBySpot(String sid) {
            return new Result<List<Comment>>() {{
                setMsg("降级处理");
            }};
        }

        @Override
        public Result<String> add(Comment comment) {
            return new Result<String>() {{
                setMsg("降级处理");
            }};
        }
    }
}

