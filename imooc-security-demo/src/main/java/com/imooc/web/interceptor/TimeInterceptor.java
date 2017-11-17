package com.imooc.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("perhandle");
        request.setAttribute("_startTime", new Date().getTime());
        System.out.println(handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        long startTime = (long) request.getAttribute("_startTime");
        System.out.println(String.format("耗时：%d", (new Date().getTime() - startTime)));

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        System.out.println("afterCompletion");
        long startTime = (long) request.getAttribute("_startTime");
        System.out.println(String.format("耗时：%d", (new Date().getTime() - startTime)));
        System.out.println(e);
    }
}
