package com.xzy.spring.interfaces.aware;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static final String XML_PATH = "interfaces/aware/application-context.xml";

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(XML_PATH);

        context.close();
    }

}
