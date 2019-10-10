package com.zaq.ssncv.ssncvproviderspot.dao.impl;

import com.zaq.ssncv.ssncvapi.entity.Spot;
import com.zaq.ssncv.ssncvproviderspot.dao.SpotDao;
import com.zaq.ssncv.ssncvproviderspot.mapper.SpotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZAQ
 */
@Repository
public class SpotDaoImpl implements SpotDao {
    private SpotMapper spotMapper;

    public SpotDaoImpl(@Autowired SpotMapper spotMapper) {
        this.spotMapper = spotMapper;
    }

    @Override
    public List<Spot> selectAll() {
        return spotMapper.selectAll();
    }

    @Override
    public List<Spot> selectWithLimit(int limit, int start) {
        return spotMapper.selectWithLimit(limit, start);
    }

    @Override
    public List<Spot> findByName(String name, int start, int limit) {
        return spotMapper.findByName(name, start, limit);
    }
}
