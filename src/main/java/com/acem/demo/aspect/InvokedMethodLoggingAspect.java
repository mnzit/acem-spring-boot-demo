package com.acem.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect
@Slf4j
@Component
public class InvokedMethodLoggingAspect {
    @Around("@annotation(com.acem.demo.aspect.annotation.InvokedMethodLog)")
    public Object methodNameLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        // Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        Object result = proceedingJoinPoint.proceed();
        // Log method execution time

        log.info(methodName + " method has been invoked of class: " +className);
        return result;
    }
}
