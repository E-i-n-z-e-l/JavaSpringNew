package com.example.Practical_08.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;
@Aspect
public class UserActionTrackingAspect {

    private Logger logger = Logger.getLogger(UserActionTrackingAspect.class.getName());

    @Around("@annotation(com.example.aspect.TrackUserAction)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        logger.info("Method " + methodName + " with parameters " + Arrays.asList(arguments) + " will execute");
        logger.info("Сообщение до вызова декорируемого метода");
        System.out.println("Сообщение до вызова декорируемого метода");
        Object returnedByMethod = joinPoint.proceed();
        logger.info("Сообщение после вызова декорируемого метода");
        System.out.println("Сообщение после вызова декорируемого метода");
        return returnedByMethod;
    }


    @Around("@annotation(com.example.aspect.ToLog)")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        logger.info("Метод: " + joinPoint.getSignature().getName() + " - " + elapsedTime + " миллисек");

        return result;
    }

    @AfterReturning("@annotation(com.example.aspect.TrackUserAction)")
    public void log(JoinPoint joinPoint) {
        logger.info("Method executed");
    }
}


