package com.lc.blog.center.interceptor;

import com.alibaba.nacos.common.constant.HttpHeaderConsts;
import com.lc.blog.center.enums.ExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author : Lu Cheng
 * @Date : 2022/9/15 22:30
 * @Version : 1.0
 */
@Slf4j
public class RequestHeaderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO 校验是否带token访问以及是否过期
        //
        if (request.getHeader("Authentication") == null) {
            log.error("拒绝访问，请检查请求参数");
            response.sendError(ExceptionEnum.TOKEN_NOT_FOUND.code, ExceptionEnum.TOKEN_NOT_FOUND.desc);
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
