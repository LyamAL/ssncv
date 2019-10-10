package com.zaq.ssncv.ssncvconsumerinterest.controller;

import com.zaq.ssncv.ssncvapi.entity.Interest;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZAQ
 */
@RequestMapping("/consumer/interest")
@RestController
public class InterestController {

    private InterestService interestService;

    public InterestController(@Autowired InterestService interestService) {
        this.interestService = interestService;
    }

    @RequestMapping(value = "/list/all")
    public Result<List<Interest>> listAll() {
        return interestService.listAll();
    }

    @RequestMapping(value = "/get")
    public Result<Interest> get() {
        return interestService.get();
    }

}
