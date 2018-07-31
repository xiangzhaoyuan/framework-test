package com.xzy.spring.interfaces.instantiationAwareBeanPostProcessor;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("目标方法前......");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("目标方法后......");
        return object;
    }

}
