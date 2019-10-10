package com.zaq.ssncv.ssncvproviderinterest.mapper;

import com.zaq.ssncv.ssncvapi.entity.Interest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZAQ
 */
@Mapper
public interface InterestMapper {

    List<Interest> selectAll();

    Interest selectOne();
}
