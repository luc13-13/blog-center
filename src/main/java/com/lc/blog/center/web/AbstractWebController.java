package com.lc.blog.center.web;

import com.lc.blog.center.constant.HttpRequestHeaderConstant;
import com.lc.blog.center.enums.ExceptionEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author : Lu Cheng
 * @Date : 2022/9/2 15:57
 * @Version : 1.0
 */
public abstract class AbstractWebController {
    @Autowired
    protected ServletRequest servletRequest;


    protected String getToken() throws Exception{
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader(HttpRequestHeaderConstant.token);
        if (StringUtils.isEmpty(token)) {
            throw new Exception(ExceptionEnum.TOKEN_NOT_FOUND.toString());
        }
        return token;
    }

    protected String getHeaderValue(String header) {
        return ((HttpServletRequest) servletRequest).getHeader(header);
    }

}
