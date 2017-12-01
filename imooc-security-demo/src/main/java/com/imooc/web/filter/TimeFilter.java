package com.imooc.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

//@Component
public class TimeFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.debug("Time filter init. ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("Time filter start. ");
        long start = new Date().getTime();
        chain.doFilter(request, response);
        logger.debug("Time filter 耗时：" + (new Date().getTime() - start) + "ms");
        logger.debug("Time filter end. ");
    }

    @Override
    public void destroy() {
        logger.debug("Time filter destroy");
    }
}