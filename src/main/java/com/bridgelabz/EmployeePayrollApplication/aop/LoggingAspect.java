package com.bridgelabz.EmployeePayrollApplication.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.bridgelabz.service.*.*(..))")
    public Object logExecutionTime(
            ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName =
                joinPoint.getSignature().getName();

        long startTime =
                System.currentTimeMillis();

        logger.info("Started service method: {}", methodName);

        try {

            Object result = joinPoint.proceed();

            long endTime =
                    System.currentTimeMillis();

            logger.info(
                    "Completed service method: {} in {} ms",
                    methodName,
                    endTime - startTime
            );

            return result;

        } catch (Exception exception) {

            long endTime =
                    System.currentTimeMillis();

            logger.error(
                    "Failed service method: {} after {} ms. Error: {}",
                    methodName,
                    endTime - startTime,
                    exception.getMessage()
            );

            throw exception;
        }
    }
}