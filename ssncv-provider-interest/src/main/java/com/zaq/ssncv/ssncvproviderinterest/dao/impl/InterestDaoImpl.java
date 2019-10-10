package com.zaq.ssncv.ssncvproviderinterest.dao.impl;

import com.zaq.ssncv.ssncvapi.entity.Interest;
import com.zaq.ssncv.ssncvproviderinterest.dao.InterestDao;
import com.zaq.ssncv.ssncvproviderinterest.mapper.InterestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InterestDaoImpl implements InterestDao {
    private InterestMapper interestMapper;

    public InterestDaoImpl(@Autowired InterestMapper interestMapper) {
        this.interestMapper = interestMapper;
    }

    @Override
    public List<Interest> selectAll() {
        return interestMapper.selectAll();
    }

    @Override
    public Interest selectOne() {
        return interestMapper.selectOne();
    }
}
