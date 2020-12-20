package com.example.demo.aop;

import org.springframework.stereotype.Component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class Monitor {

    private static final Logger logger =
        LoggerFactory.getLogger(Monitor.class);


    @Before("execution(public * com.example.demo.aop.PersonRepo.findAll(..))")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Method " + methodName + " is about to be called");
    }
}
