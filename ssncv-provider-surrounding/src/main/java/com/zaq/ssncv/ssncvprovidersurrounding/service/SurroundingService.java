package com.zaq.ssncv.ssncvprovidersurrounding.service;

import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.Surrounding;

import java.util.List;

/**
 * @author ZAQ
 */
public interface SurroundingService {
    Result<List<Surrounding>> listAll();
}
