package com.zaq.ssncv.ssncvproviderspot.dao;

import com.zaq.ssncv.ssncvapi.entity.Spot;

import java.util.List;

/**
 * @author ZAQ
 */
public interface SpotDao {

    List<Spot> selectAll();

    List<Spot> selectWithLimit(int start, int limit);

    List<Spot> findByName(String name, int start, int limit);
}
