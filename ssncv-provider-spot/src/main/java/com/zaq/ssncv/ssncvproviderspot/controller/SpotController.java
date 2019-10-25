package com.zaq.ssncv.ssncvproviderspot.controller;

import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.Spot;
import com.zaq.ssncv.ssncvproviderspot.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZAQ
 */
@RestController
@RequestMapping("/spot")
public class SpotController {
    private SpotService spotService;

    public SpotController(@Autowired SpotService spotService) {
        this.spotService = spotService;
    }

    @RequestMapping("/list/{name}")
    public Result<List<Spot>> matchName(@PathVariable String name, @RequestParam int start, @RequestParam int limit) {
        return spotService.matchName(name, start, limit);
    }

    @RequestMapping("/list/all")
    public Result<List<Spot>> listAll(@RequestParam(required = false) int start, @RequestParam(required = false) int limit) {
        return spotService.list(start, limit);
    }

}
