package com.xzy.spring.interfaces.beanFactoryPostProcessor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static final String XML_PATH = "interfaces/beanFactoryPostProcessor/application-context.xml";

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(XML_PATH);

        FootballPlayer footballPlayer = (FootballPlayer) context.getBean("footballPlayer");
        System.out.println(footballPlayer);

        context.close();
    }

}
