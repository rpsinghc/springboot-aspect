package com.example.aspect;

import com.example.aop.example.ChildService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class Service {

    ChildService childService = new ChildService();
 // @Autowired
//    ChildService childService;// = new ChildService();

    @Cacheable("tool")
    public String getCachedData(String name){
        //ildService.getChildData("me");
        return ""+System.currentTimeMillis();
    }

    public String getNonCachedData(String name){
        childService.getChildData("me");
        //System.out.println(childService.getData("me"));
        //System.out.println(childService.getChildData("me"));
        return ""+System.currentTimeMillis();
    }
}
