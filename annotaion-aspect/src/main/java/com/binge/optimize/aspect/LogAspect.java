package com.binge.optimize.aspect;


import com.binge.optimize.service.LogService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private LogService logService;


    private void around(){}
}
