package com.example.demo.aop;

import com.example.demo.entities.Movie;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MovieAspect {

    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    public void controllerPointCut(){}

//    @Pointcut("within(com.example.demo.service.impl.*)")
    @Pointcut("@annotation(com.example.demo.aop.MovieAspectAnnotation)")
    public void servicePointCut(){}

    @Before("controllerPointCut()")
    public void before(JoinPoint joinPoint) {
        log.info("Before AOP :: "+joinPoint.getSignature());
    }

    @After("servicePointCut()")
    public void after(JoinPoint joinPoint) {
        log.info("After AOP :: "+joinPoint.getSignature());
    }

    @Around("servicePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Around AOP :: "+joinPoint.getSignature());
        Object obj = joinPoint.proceed();
        if(obj instanceof Movie) {
            log.info("Get Movie Entity from "+joinPoint.getSignature().getName());
        }
        return obj;
    }
}
