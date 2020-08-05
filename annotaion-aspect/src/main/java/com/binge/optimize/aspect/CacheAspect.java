package com.binge.optimize.aspect;


import com.binge.optimize.service.CacheService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CacheAspect {

    @Autowired
    private CacheService cacheService;
}
