package com.zaq.ssncv.ssncvprovideruser.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZAQ
 */
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(UnauthorizedEntryPoint.class);

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        // return 401 UNAUTHORIZED status code if the user is not authenticated
        logger.debug(" *** UnauthorizedEntryPoint.commence: " + httpServletRequest.getRequestURI());
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
