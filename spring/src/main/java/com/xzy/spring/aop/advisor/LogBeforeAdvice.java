package com.xzy.spring.aop.advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;


public class LogBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("===============LogBeforeAdvice start==============");
        System.out.println("method: " + method.getName());
        System.out.println("args: " + Arrays.asList(args));
        System.out.println("target: " + target.getClass().getName());
        System.out.println("===============LogBeforeAdvice end================");
    }

}
