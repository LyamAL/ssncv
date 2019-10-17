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
    private static final String MSG_ERROR = "数据库查询错误";
    private static final String MSG_SUCCESS = "success";
    private SpotService spotService;

    public SpotController(@Autowired SpotService spotService) {
        this.spotService = spotService;
    }

    @RequestMapping("/list/{name}")
    public Result<List<Spot>> matchName(@PathVariable String name, @RequestParam int start, @RequestParam int limit) {
        List<Spot> list = spotService.matchName(name, start, limit);
        Result<List<Spot>> res = new Result<>();
        res.setSuccess(list != null);
        res.setMsg(list != null ? MSG_SUCCESS : MSG_ERROR);
        res.setData(list);
        return res;
    }

    @RequestMapping("/list/all")
    public Result<List<Spot>> listAll(@RequestParam int start, @RequestParam int limit) {
        Result<List<Spot>> res = new Result<>();
        List<Spot> list = spotService.list(start, limit);
        res.setSuccess(list != null);
        res.setMsg(list != null ? MSG_SUCCESS : MSG_ERROR);
        res.setData(list);
        return res;
    }


}
