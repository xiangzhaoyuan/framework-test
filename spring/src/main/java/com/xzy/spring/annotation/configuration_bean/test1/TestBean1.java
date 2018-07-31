package com.xzy.spring.annotation.configuration_bean.test1;

public class TestBean1 {

    public void sayHello() {
        System.out.println("TestBean1 sayHello...");
    }

    public void init() {
        System.out.println("TestBean1 初始化...");
    }

    public void destroy() {
        System.out.println("TestBean1 销毁...");
    }

}
