package com.zaq.ssncv.ssncvapi.service;

import com.zaq.ssncv.ssncvapi.entity.Result;

/**
 * @author ZAQ
 */
public abstract class BaseService {
    private static final String SUCCESS = "操作成功";
    private static final String ERROR = "数据库错误";

    private boolean isSuccess(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj > 0;
        }
        return obj != null;
    }

    protected void wrapResponse(Result responseEntity, Object data) {
        if (isSuccess(data)) {
            responseEntity.setSuccess(true);
            responseEntity.setMsg(SUCCESS);
        } else {
            responseEntity.setMsg(ERROR);
            responseEntity.setSuccess(false);
        }
        responseEntity.setData(data);
    }

    protected void wrapResponse(Result responseEntity, Object data, String customMsg) {
        wrapResponse(responseEntity, data);
        if (customMsg != null) {
            responseEntity.setMsg(customMsg);
        }
    }

}
