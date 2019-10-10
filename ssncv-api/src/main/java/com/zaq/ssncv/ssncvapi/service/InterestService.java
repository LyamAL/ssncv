package com.zaq.ssncv.ssncvapi.service;

import com.zaq.ssncv.ssncvapi.entity.Interest;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.fallback.InterestServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ZAQ
 */
@FeignClient(value = "SSNCV-PROVIDER-INTEREST", fallbackFactory = InterestServiceFallbackFactory.class)
@RequestMapping("/interest")
public interface InterestService {
    @RequestMapping("/list/all")
    Result<List<Interest>> listAll();

    @RequestMapping("/get")
    Result<Interest> get();
}
