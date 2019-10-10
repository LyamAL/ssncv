package com.zaq.ssncv.ssncvapigateway.filter;

import com.netflix.zuul.ZuulFilter;

/**
 * @author ZAQ
 */
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("error");
        return null;
    }
}
