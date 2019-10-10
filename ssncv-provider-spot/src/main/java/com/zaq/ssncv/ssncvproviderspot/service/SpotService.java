package com.zaq.ssncv.ssncvproviderspot.service;

import com.zaq.ssncv.ssncvapi.entity.Spot;

import java.util.List;

/**
 * @author ZAQ
 */
public interface SpotService {
    List<Spot> listAll();

    List<Spot> list(int start, int limit);

    List<Spot> matchName(String name, int start, int limit);
}
