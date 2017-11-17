package com.imooc.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class TimeAspect {
    @Around("execution (* com.imooc.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("time aspect start");

        long startTime = new Date().getTime();

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println(String.format("arg is: %s", arg));
        }

        Object object = pjp.proceed();


        System.out.println(String.format("TimeAspect 耗时：%d", (new Date().getTime() - startTime)));

        System.out.println("time aspect end");
        return object;
    }
}
