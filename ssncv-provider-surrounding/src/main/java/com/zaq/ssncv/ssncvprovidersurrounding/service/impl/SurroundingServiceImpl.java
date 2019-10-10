package com.zaq.ssncv.ssncvprovidersurrounding.service.impl;

import com.zaq.ssncv.ssncvapi.entity.Surrounding;
import com.zaq.ssncv.ssncvprovidersurrounding.dao.SurroundingDao;
import com.zaq.ssncv.ssncvprovidersurrounding.service.SurroundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZAQ
 */
@Service
public class SurroundingServiceImpl implements SurroundingService {
    private SurroundingDao surroundingDao;

    public SurroundingServiceImpl(@Autowired SurroundingDao surroundingDao) {
        this.surroundingDao = surroundingDao;
    }

    @Override
    public List<Surrounding> listAll() {
        return surroundingDao.selectAll();
    }
}
