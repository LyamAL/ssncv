package com.zaq.ssncv.ssncvproviderinterest.service.impl;

import com.zaq.ssncv.ssncvapi.entity.Interest;
import com.zaq.ssncv.ssncvproviderinterest.dao.InterestDao;
import com.zaq.ssncv.ssncvproviderinterest.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestServiceImpl implements InterestService {
    private InterestDao interestDao;

    public InterestServiceImpl(@Autowired InterestDao interestDao) {
        this.interestDao = interestDao;
    }

    @Override
    public List<Interest> listAll() {
        return interestDao.selectAll();
    }

    @Override
    public Interest get() {
        return interestDao.selectOne();
    }
}
