package com.xkcoding.log.aop.aspectj;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author laiyuan
 * @date 2020/12/25
 */
@Aspect
@Component
public class MyAop {
    /**
     * 切入点
     */
    @Pointcut("execution(public * com.xkcoding.log.aop..*.*(..))")
    public void myLog() {

    }

    @Before("myLog()")
    public void Before(){
        System.out.println("aop - 方法执行前");
    }

    @After("myLog()")
    public void after(){
        System.out.println("aop - 方法执行后");
    }

    @AfterReturning("myLog()")
    public void afterReturning(){
        System.out.println("aop - 方法结束后");
    }

    @Around("myLog()")
    @SneakyThrows
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("aop - 环绕开始");
        proceedingJoinPoint.proceed();
        System.out.println("aop - 环绕结束");
    }
}
