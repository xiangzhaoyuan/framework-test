package com.xzy.spring.spel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static final String XML_PATH = "spel/application-context.xml";

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(XML_PATH);

        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello);

        Hello world = (Hello) context.getBean("world");
        System.out.println(world);

        context.close();
    }

}
