package com.zaq.ssncv.ssncvprovidersurrounding.mapper;

import com.zaq.ssncv.ssncvapi.entity.Surrounding;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZAQ
 */
@Mapper
public interface SurroundingMapper {
    List<Surrounding> selectAll();
}
