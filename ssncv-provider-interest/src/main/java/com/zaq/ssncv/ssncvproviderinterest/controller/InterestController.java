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
        return interestService.listAll();
    }

    @RequestMapping("/get")
    public Result<Interest> get() {
        return interestService.get();
    }


}
