package com.example.aop.example;


public abstract class ParentService {


    protected String getData() {
        return "parent super - " + System.currentTimeMillis();
    }
}
