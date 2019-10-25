package com.zaq.ssncv.ssncvproviderspot.service.impl;

import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.Spot;
import com.zaq.ssncv.ssncvapi.service.BaseService;
import com.zaq.ssncv.ssncvproviderspot.dao.SpotDao;
import com.zaq.ssncv.ssncvproviderspot.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZAQ
 */
@Service
public class SpotServiceImpl extends BaseService implements SpotService {

    private SpotDao spotDao;

    public SpotServiceImpl(@Autowired SpotDao spotDao) {
        this.spotDao = spotDao;
    }

    @Override
    public Result<List<Spot>> listAll() {
        Result<List<Spot>> result = new Result<>();
        List<Spot> list = spotDao.selectAll();
        wrapResponse(result, list);
        return result;
    }

    @Override
    public Result<List<Spot>> list(int start, int limit) {
        Result<List<Spot>> result = new Result<>();
        List<Spot> list = spotDao.selectWithLimit(start, limit);
        wrapResponse(result, list);
        return result;
    }

    @Override
    public Result<List<Spot>> matchName(String name, int start, int limit) {
        Result<List<Spot>> result = new Result<>();
        List<Spot> list = spotDao.findByName(name, start, limit);
        wrapResponse(result, list);
        return result;
    }
}
