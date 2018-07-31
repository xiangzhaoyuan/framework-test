package com.xzy.spring.annotation.value;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ValueTest {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("/annotation/value/application-context.xml");
        Demo1 demo1 = (Demo1) beanFactory.getBean("demo1");
        System.out.println(demo1);

        Demo2 demo2 = (Demo2) beanFactory.getBean("demo2");
        System.out.println(demo2);
    }

}
