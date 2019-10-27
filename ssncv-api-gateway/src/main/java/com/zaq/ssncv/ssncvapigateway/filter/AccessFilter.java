package com.zaq.ssncv.ssncvapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;

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
        ctx.addZuulRequestHeader("original_accessToken", request.getHeader("AccessToken"));
        String accessToken = request.getHeader("AccessToken");
        String url = request.getRequestURI();
        if ("/api/comment/list".equals(url)&& request.getParameterMap().containsKey("sid")){
            URL u = ctx.getRouteHost();

        }
        if (accessToken != null && accessToken.startsWith("Bearer")) {
            String token = accessToken.replace("Bearer ", "");
            if (url.contains("user/add") || url.contains("user/login")) {
                return null;
            }
            if ("".equals(token)) {
                System.out.println("token is empty");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                return null;
            }
        } else {
            if (url.contains("image")) {
                System.out.println("retrieve image resource");
                return null;
            }
            System.out.println("token is null");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
}
