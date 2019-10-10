package com.zaq.ssncv.ssncvapi.service;

import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.Surrounding;
import com.zaq.ssncv.ssncvapi.fallback.SurroundingServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ZAQ
 */
@FeignClient(value = "SSNCV-PROVIDER-SURROUNDING",
        fallbackFactory = SurroundingServiceFallbackFactory.class)
@RequestMapping("/surrounding")
public interface SurroundingService {
    @RequestMapping("/list/all")
    Result<List<Surrounding>> listAll();
//    List<Surrounding> listAll();
}
