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
    Result<List<Spot>> listAll(@RequestParam(value = "start", required = false) int start, @RequestParam(value = "limit", required = false) int limit);

    @RequestMapping("/list/{name}")
    Result<List<Spot>> matchName(@PathVariable(value = "name") String name, @RequestParam(value = "start", required = false) int start, @RequestParam(value = "limit", required = false) int limit);
}
