package com.xzy.spring.interfaces.beanPostProcessor;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TestBean2 implements InitializingBean, DisposableBean {

    public TestBean2() {
        System.out.println("TestBean2--construct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TestBean2--InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("TestBean2--DisposableBean");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("TestBean2--@PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("TestBean2--@PreDestroy");
    }

    public void initMethod() {
        System.out.println("TestBean2--init-method");
    }

    public void destroyMethod() {
        System.out.println("TestBean2--destroy-method");
    }

    public void execute() {
        System.out.println("TestBean2--execute");
    }

}
