package com.xzy.spring.aop.advisor;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(IllegalArgumentException e) {
        System.out.println("================方法调用异常，抛出IllegalArgumentException");
    }

    public void afterThrowing(NumberFormatException e) {
        System.out.println("================方法调用异常，抛出NumberFormatException");
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
        System.out.println("================方法调用异常，抛出" + e.getClass().getName());
        System.out.println("method: " + method.getName());
        System.out.println("args: " + Arrays.asList(args));
        System.out.println("target: " + target.getClass().getName());
    }

}
