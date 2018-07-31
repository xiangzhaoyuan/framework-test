package com.xzy.spring.annotation.autowired_resource.test1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static final String XML_PATH = "annotation/autowired_resource/application-context.xml";

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(XML_PATH);

        HumanService humanService = (HumanService) context.getBean("humanService");
        humanService.showAction();

        context.close();
    }

}
