package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
public class AspectO{


    @Before("execution(public * com.example.aspect.Service.getCachedData(..))")
    public void test(){
        System.out.println("BEgore cached data");
    }

    @Around("execution(protected String com.example.aop.example.*.*())")
    public String parentService(ProceedingJoinPoint jPoint) throws Throwable{
        System.out.println("parent cached data");
        return "from parent aspect";
    }



    @Around("execution(protected * org.springframework.cache.interceptor.AbstractCacheInvoker.doGet(..))")
    public Object test2(ProceedingJoinPoint jPoint) throws Throwable{
        //i need this working
        System.out.println("BEgore2 cached data");
        Object o = jPoint.proceed();
        System.out.println("in execution " + o);
        return o;
    }
}
