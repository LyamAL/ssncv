package com.zaq.ssncv.ssncvproviderinterest.service;

import com.zaq.ssncv.ssncvapi.entity.Interest;

import java.util.List;

/**
 * @author ZAQ
 */
public interface InterestService {
    List<Interest> listAll();

    Interest get();
}
