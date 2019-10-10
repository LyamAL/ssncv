package com.zaq.ssncv.ssncvproviderinterest.dao;

import com.zaq.ssncv.ssncvapi.entity.Interest;

import java.util.List;

public interface InterestDao {

    List<Interest> selectAll();

    Interest selectOne();
}
