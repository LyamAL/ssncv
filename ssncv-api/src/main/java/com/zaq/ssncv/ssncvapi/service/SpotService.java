package com.zaq.ssncv.ssncvapi.service;

import com.zaq.ssncv.ssncvapi.FeignConfiguration;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.Spot;
import com.zaq.ssncv.ssncvapi.fallback.SpotServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author ZAQ
 */
@FeignClient(value = "SSNCV-PROVIDER-SPOT", configuration = FeignConfiguration.class,
        fallbackFactory = SpotServiceFallbackFactory.class)
@RequestMapping("/spot")
public interface SpotService {
    @RequestMapping("/list/all")
    Result<List<Spot>> listAll(@RequestParam int start, @RequestParam int limit);

    @RequestMapping("/list/{name}")
    Result<List<Spot>> matchName(@PathVariable String name, @RequestParam int start, @RequestParam int limit);
}
