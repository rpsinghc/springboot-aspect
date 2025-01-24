package com.example.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Configuration
//@EnableAspectJAutoProxy
@EnableLoadTimeWeaving
public class AspectConfig {


    @Bean
    AspectO AspectO(){
        return new AspectO();
    }




}
