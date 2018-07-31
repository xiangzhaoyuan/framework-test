package com.xzy.spring.aop.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String name = invocation.getMethod().getName();
        System.out.println("================LogAroundAdvice,方法调用开始===============method：" + name);
        try {
            Object result = invocation.proceed();
            System.out.println("================LogAroundAdvice,方法调用结束===============method：" + name);
            return result;
        } catch (Exception e) {
            System.out.println("================LogAroundAdvice,方法调用异常===============method：" + name);
            throw e;
        }
    }

}
