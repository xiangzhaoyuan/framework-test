package com.xzy.spring.annotation.init_destroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Bean在实例化的过程（依赖注入已经完成）中：Constructor > @PostConstruct > InitializingBean > init-method
 * Bean在销毁的过程中：@PreDestroy > DisposableBean > destroy-method
 */
public class TestBean implements InitializingBean, DisposableBean {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TestBean() {
        System.out.println("TestBean--construct, value:" + value);
    }

    /**
     * 在afterPropertiesSet()方法中抛出异常，那么初始化会被终止，不会执行后面的init-method对应的初始化方法
     * afterPropertiesSet()方法的效率比init-method高，因为init-method使用的是反射来寻找对应的方法，而afterPropertiesSet()则是直接执行的
     * Spring中初始化的Bean的类为org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
        //throw new RuntimeException("exception");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct, value:" + value);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy");
    }

    /**
     * init-method只能是无参无返回的public方法
     */
    public void initMethod() {
        System.out.println("init-method");
    }

    public void destroyMethod() {
        System.out.println("destroy-method");
    }

    public void execute() {
        System.out.println("TestBean--execute");
    }

}
