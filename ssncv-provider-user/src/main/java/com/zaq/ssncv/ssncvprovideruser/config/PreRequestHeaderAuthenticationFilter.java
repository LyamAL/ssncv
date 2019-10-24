package com.zaq.ssncv.ssncvprovideruser.config;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZAQ
 */
public class PreRequestHeaderAuthenticationFilter
        extends AbstractPreAuthenticatedProcessingFilter {
    /*Token串储存在“SM_UER”的header里*/
    private String principalRequestHeader = "SM_USER";
    private String credentialsRequestHeader;
    private boolean exceptionIfHeaderMissing = true;

    @Override
    protected Object getPreAuthenticatedPrincipal
            (HttpServletRequest httpServletRequest) {
        if (credentialsRequestHeader != null) {
            return httpServletRequest.getHeader(credentialsRequestHeader);
        }
        return "N/A";
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest httpServletRequest) {
        /*获取principal信息*/
        String principal = httpServletRequest.getHeader(principalRequestHeader);
        if (principal == null && exceptionIfHeaderMissing) {
            // 对于request进行BadException处理
            httpServletRequest.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION
                    , new BadCredentialsException("No pre-authenticated credentials found in request."));
            return "N/A";
        }
        return principal;
    }

    public void setPrincipalRequestHeader(String principalRequestHeader) {
        Assert.hasText(principalRequestHeader, "principalRequestHeader must not be empty or null");
        this.principalRequestHeader = principalRequestHeader;
    }

    public void setCredentialsRequestHeader(String credentialsRequestHeader) {
        Assert.hasText(credentialsRequestHeader,
                "credentialsRequestHeader must not be empty or null");
        this.credentialsRequestHeader = credentialsRequestHeader;
    }

    public void setExceptionIfHeaderMissing(boolean exceptionIfHeaderMissing) {
        this.exceptionIfHeaderMissing = exceptionIfHeaderMissing;
    }
}
