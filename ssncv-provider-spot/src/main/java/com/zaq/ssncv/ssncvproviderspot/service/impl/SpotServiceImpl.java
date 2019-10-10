package com.zaq.ssncv.ssncvproviderspot.service.impl;

import com.zaq.ssncv.ssncvapi.entity.Spot;
import com.zaq.ssncv.ssncvproviderspot.dao.SpotDao;
import com.zaq.ssncv.ssncvproviderspot.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZAQ
 */
@Service


public class SpotServiceImpl implements SpotService {

    private SpotDao spotDao;

    public SpotServiceImpl(@Autowired SpotDao spotDao) {
        this.spotDao = spotDao;
    }

    @Override
    public List<Spot> listAll() {
        return spotDao.selectAll();
    }

    @Override
    public List<Spot> list(int start, int limit) {
        return spotDao.selectWithLimit(start, limit);
    }

    @Override
    public List<Spot> matchName(String name, int start, int limit) {
        return spotDao.findByName(name, start, limit);
    }
}
