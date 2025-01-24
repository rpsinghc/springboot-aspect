package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectT {


    @Before("execution( protected String com.example.aop.example.ParentService.getData())")
    public void test(){
        System.out.println("BEgore cached data for aspectT");
    }

    @Before("execution( public String com.example.aspect.Service.getNonCachedData(..))")
    public void test1(){
        System.out.println("BEgore cached data for aspect2");
    }


}
