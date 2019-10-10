package com.zaq.ssncv.ssncvprovidersurrounding.dao.impl;

import com.zaq.ssncv.ssncvapi.entity.Surrounding;
import com.zaq.ssncv.ssncvprovidersurrounding.dao.SurroundingDao;
import com.zaq.ssncv.ssncvprovidersurrounding.mapper.SurroundingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SurroundingDaoImpl implements SurroundingDao {
    private SurroundingMapper surroundingMapper;

    public SurroundingDaoImpl(@Autowired SurroundingMapper surroundingMapper) {
        this.surroundingMapper = surroundingMapper;
    }

    @Override
    public List<Surrounding> selectAll() {
        return surroundingMapper.selectAll();
    }
}
