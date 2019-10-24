package com.zaq.ssncv.ssncvprovideruser2.service;

import com.zaq.ssncv.ssncvapi.entity.Result;

public abstract class BaseService {
    public static String SUCCESS = "success";
    public static String ERROR = "error";

    private boolean isSuccess(Object o) {
        if (o instanceof Integer) {
            return (Integer) o > 0;
        }
        return o != null;
    }

    protected void wrapResponse(Result response, Object o) {
        if (isSuccess(o)) {
            response.setSuccess(true);
            response.setMsg(SUCCESS);
        } else {
            response.setMsg(ERROR);
            response.setSuccess(false);
        }
        response.setData(o);
    }

    protected void wrapResponse(Result response, Object o, String message) {
        wrapResponse(response, o);
        if (message != null) {
            response.setMsg(message);
        }
    }

}
