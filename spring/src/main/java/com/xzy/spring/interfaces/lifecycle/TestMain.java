package com.xzy.spring.interfaces.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static final String XML_PATH = "interfaces/lifecycle/application-context.xml";

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(XML_PATH);

        TestBean testBean = (TestBean) context.getBean("testBean");
        testBean.printTime();

        context.close();
    }

}
