package com.zaq.ssncv.ssncvproviderinterest.service;

import com.zaq.ssncv.ssncvapi.entity.Interest;
import com.zaq.ssncv.ssncvapi.entity.Result;

import java.util.List;

/**
 * @author ZAQ
 */
public interface InterestService {
    Result<List<Interest>> listAll();

    Result<Interest> get();
}
