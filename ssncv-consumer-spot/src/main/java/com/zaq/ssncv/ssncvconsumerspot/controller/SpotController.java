package com.zaq.ssncv.ssncvconsumerspot.controller;

import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.Spot;
import com.zaq.ssncv.ssncvapi.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZAQ
 */
@RequestMapping("/consumer/spot")
@RestController
public class SpotController {

    private SpotService spotService;

    public SpotController(@Autowired SpotService spotService) {
        this.spotService = spotService;
    }

    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
    public Result<List<Spot>> listAll(@RequestParam int start, @RequestParam int limit) {
        return spotService.listAll(start, limit);
    }

    @RequestMapping("/list/{name}")
    public Result<List<Spot>> matchName(@PathVariable String name, @RequestParam int start, @RequestParam int limit) {
        return spotService.matchName(name, start, limit);
    }


}
