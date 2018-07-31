package com.xzy.spring.interfaces.instantiationAwareBeanPostProcessor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static final String XML_PATH = "interfaces/instantiationAwareBeanPostProcessor/application-context.xml";

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(XML_PATH);
        Action action = context.getBean("action", Action.class);
        action.doSomething();
        System.out.println(action.getValue());
        context.close();
    }

}
