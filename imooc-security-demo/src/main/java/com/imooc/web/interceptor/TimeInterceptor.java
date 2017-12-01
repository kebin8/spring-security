package com.imooc.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class TimeInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.debug("PreHandle");

        logger.debug(((HandlerMethod)handler).getBean().getClass().getName());
        logger.debug(((HandlerMethod)handler).getMethod().getName());

        request.setAttribute("startTime", new Date().getTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        logger.debug("PostHandle");

        Long start = (Long) request.getAttribute("startTime");
        logger.debug("Time interceptor 耗时：" + (new Date().getTime() - start) + "ms");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.debug("AfterCompletion");

        Long start = (Long) request.getAttribute("startTime");
        logger.debug("Time interceptor 耗时：" + (new Date().getTime() - start) + "ms");
        logger.debug("ex is " + ex);
    }
}