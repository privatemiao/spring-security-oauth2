package com.imooc.web.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

//@Component //改为通过类配置的方式
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TimeFilter init.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("TimeFilter begin.");
        long startTime = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println(String.format("TimeFilter 耗时：%d", (new Date().getTime() - startTime)));
        System.out.println("TimeFilter finish.");
    }

    @Override
    public void destroy() {
        System.out.println("TimeFilter destroy.");
    }
}
