package com.zaq.ssncv.ssncvapigateway.filter;

import com.netflix.zuul.ZuulFilter;

/**
 * @author ZAQ
 */
public class PostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        return null;
    }
}
