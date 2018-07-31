package com.xzy.spring.interfaces.applicationListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static final String XML_PATH = "interfaces/applicationListener/application-context.xml";

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(XML_PATH);

        EmailSendAction emailSendAction = (EmailSendAction) context.getBean("emailSendAction");
        emailSendAction.login("zhang3@163.com", "123456");

        context.close();
    }


}
