package com.example.demo.service.Impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAop {

    @Pointcut("execution(* com.example.demo.service.Impl.DaoTestService.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint) throws Throwable {
        System.out.println("方法执行前");
    }

    @After("pointCut()")
    public void afterMethod() {
        System.out.println("方法执行后");
    }

    @AfterReturning("pointCut()")
    public void afterReturn() {
        System.out.println("方法返回后");
    }

    @AfterThrowing("pointCut()")
    public void afterThrow() {
        System.out.println("方法异常后");
    }

    @Around("pointCut()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("方法环绕1");
        proceedingJoinPoint.proceed();
        System.out.println("方法环绕2");
        return 1;
    }
}
