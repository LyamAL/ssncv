package com.zaq.ssncv.ssncvprovideruser.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZAQ
 */
@Component("authenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        // 把authentication对象转成 json 格式 字符串 通过 response 以application/json;charset=UTF-8 格式写到响应里面去
        Result<User> result = new Result<>();
        result.setSuccess(true);
        result.setMsg("登录成功");
        result.setData((User) authentication.getPrincipal());
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
