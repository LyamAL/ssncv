package com.zaq.ssncv.ssncvproviderspot.mapper;

import com.zaq.ssncv.ssncvapi.entity.Spot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpotMapper {

    List<Spot> selectAll();

    List<Spot> selectWithLimit(@Param("start") int start, @Param("limit") int limit);

    List<Spot> findByName(@Param("name") String name, @Param("start") int start, @Param("limit") int limit);

}
