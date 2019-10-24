package com.zaq.ssncv.ssncvprovideruser2.entity;

import org.springframework.stereotype.Component;

/**
 * @author ZAQ
 */
@Component
public class AuthParameters {
    private String jwtTokenSecret;
    private long tokenExpiredMs;

    public String getJwtTokenSecret() {
        return "ssncv";
    }

    //    @Value("${jwtTokenSecret}")
    public void setJwtTokenSecret(String jwtTokenSecret) {
        this.jwtTokenSecret = jwtTokenSecret;
    }

    public long getTokenExpiredMs() {
        return 604800000;
    }

    //    @Value("${tokenExpiredMs}")
    public void setTokenExpiredMs(long tokenExpiredMs) {
        this.tokenExpiredMs = tokenExpiredMs;
    }
}
