package com.zaq.ssncv.ssncvapi.service;

import com.zaq.ssncv.ssncvapi.entity.Comment;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.fallback.CommentServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ZAQ
 */
@FeignClient(value = "SSNCV-PROVIDER-COMMENT", fallbackFactory = CommentServiceFallbackFactory.class)
@RequestMapping("/comment")
public interface CommentService {
    @RequestMapping("/get")
    Result<List<Comment>> listBySpot(@RequestParam String sid);

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    Result<String> add(@RequestBody Comment comment);

}