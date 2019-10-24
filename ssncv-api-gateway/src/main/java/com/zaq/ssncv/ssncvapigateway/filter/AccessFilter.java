package com.zaq.ssncv.ssncvapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZAQ
 */
public class AccessFilter extends ZuulFilter {
    /**
     * 代表会在请求被路由之前执行
     */
    @Override
    public String filterType() {
        return "route";
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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        ctx.addZuulRequestHeader("original_authorization", request.getHeader("Authorization"));
        //        RequestContext ctx = RequestContext.getCurrentContext();
//        System.out.println(String.format("send %s request to %s", request.getMethod(), request.getRequestURL().toString()));
//        Object accsessToken = request.getParameter("accessToken");
//        if (accsessToken == null) {
//            System.out.println("access token is empty");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            return null;
//        }
//        System.out.println("access token is OK");
        return null;
    }
}
