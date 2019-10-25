package com.zaq.ssncv.ssncvproviderspot.service;

import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.Spot;

import java.util.List;

/**
 * @author ZAQ
 */
public interface SpotService {
    Result<List<Spot>> listAll();

    Result<List<Spot>> list(int start, int limit);

    Result<List<Spot>> matchName(String name, int start, int limit);
}
