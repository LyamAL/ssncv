package com.zaq.ssncv.ssncvproviderinterest.service.impl;

import com.zaq.ssncv.ssncvapi.entity.Interest;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.service.BaseService;
import com.zaq.ssncv.ssncvproviderinterest.dao.InterestDao;
import com.zaq.ssncv.ssncvproviderinterest.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZAQ
 */
@Service
public class InterestServiceImpl extends BaseService implements InterestService {
    private InterestDao interestDao;

    public InterestServiceImpl(@Autowired InterestDao interestDao) {
        this.interestDao = interestDao;
    }

    @Override
    public Result<List<Interest>> listAll() {
        Result<List<Interest>> result = new Result<>();
        wrapResponse(result, interestDao.selectAll());
        return result;
    }

    @Override
    public Result<Interest> get() {
        Result<Interest> result = new Result<>();
        wrapResponse(result, interestDao.selectOne());
        return result;
    }
}
