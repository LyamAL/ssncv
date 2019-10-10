package com.zaq.ssncv.ssncvproviderinterest.controller;

import com.zaq.ssncv.ssncvapi.entity.Interest;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvproviderinterest.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZAQ
 */
@RestController
@RequestMapping("/interest")
public class InterestController {
    private InterestService interestService;

    public InterestController(@Autowired InterestService interestService) {
        this.interestService = interestService;
    }

    @RequestMapping("/list/all")
    public Result<List<Interest>> list() {
        Result<List<Interest>> res = new Result<>();
        List<Interest> list = interestService.listAll();
        res.setSuccess(list != null);
        res.setMsg(list != null ? "success" : "error");
        res.setData(list);
        return res;
    }

    @RequestMapping("/get")
    public Result<Interest> get() {
        Result<Interest> res = new Result<>();
        Interest interest = interestService.get();
        res.setSuccess(interest != null);
        res.setMsg(interest != null ? "success" : "error");
        res.setData(interest);
        return res;
    }


}
