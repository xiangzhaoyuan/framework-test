package com.xzy.spring.interfaces.scope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static final String XML_PATH = "interfaces/scope/application-context.xml";

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(XML_PATH);
        context.getBeanFactory().registerScope("myScope", new MyScope());
        context.getBean("myBean");
        context.getBean("myBean");

        context.close();
    }

}
