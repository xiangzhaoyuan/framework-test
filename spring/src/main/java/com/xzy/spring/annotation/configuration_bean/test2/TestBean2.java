package com.xzy.spring.annotation.configuration_bean.test2;

import org.springframework.stereotype.Component;

@Component("testBean2")
public class TestBean2 {

    public void sayHello() {
        System.out.println("TestBean2 sayHello...");
    }

    public void init() {
        System.out.println("TestBean2 初始化...");
    }

    public void destroy() {
        System.out.println("TestBean2 销毁...");
    }

}
