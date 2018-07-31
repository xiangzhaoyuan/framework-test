package com.xzy.spring.annotation.init_destroy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotation/init_destroy/application-context.xml");
        TestBean testBean = (TestBean) context.getBean("testBean");
        testBean.execute();
        context.close();
    }

}
