package com.xzy.spring.aop.advisor;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class LogAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("================AfterReturningAdvice, method: " + method.getName() + "，调用成功返回值：" + returnValue);
    }

}