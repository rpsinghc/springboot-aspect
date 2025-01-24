package com.example.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
public class AspectApplication implements CommandLineRunner {

    @Autowired
    Service service;


    public static void main(String[] args) {
        SpringApplication.run(AspectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(service.getCachedData("1"));
        System.out.println(service.getCachedData("1"));
        System.out.println(service.getCachedData("1"));
        System.out.println(service.getCachedData("1"));


        System.out.println(service.getNonCachedData("4"));
        System.out.println(service.getNonCachedData("4"));
        System.out.println(service.getNonCachedData("4"));
        System.out.println(service.getNonCachedData("4"));

        System.out.println("testme");
    }
}
