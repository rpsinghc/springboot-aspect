package com.example.aop.example;


public class ChildService extends ParentService {


     public String getChildData(String name) {
         System.out.println(getData());
        return "child super - " + System.currentTimeMillis();
    }
}
