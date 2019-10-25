package com.zaq.ssncv.ssncvprovidersurrounding.controller;

import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.Surrounding;
import com.zaq.ssncv.ssncvprovidersurrounding.service.SurroundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZAQ
 */
@RestController
@RequestMapping("/surrounding")
public class SurroundingController {
    private SurroundingService surroundingService;

    public SurroundingController(@Autowired SurroundingService surroundingService) {
        this.surroundingService = surroundingService;
    }

    @RequestMapping("/list/all")
    public Result<List<Surrounding>> listAll() {
        return surroundingService.listAll();
    }

}
