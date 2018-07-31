package com.xzy.spring.interfaces.classPathBeanDefinitionScanner;

import com.xzy.spring.interfaces.classPathBeanDefinitionScanner.one.HelloOne;
import com.xzy.spring.interfaces.classPathBeanDefinitionScanner.two.HelloTwo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static final String XML_PATH = "interfaces/classPathBeanDefinitionScanner/application-context.xml";

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(XML_PATH);

        HelloOne helloOne = context.getBean(HelloOne.class);
        System.out.println(helloOne);

        HelloTwo helloTwo = context.getBean(HelloTwo.class);
        System.out.println(helloTwo);

        context.close();

    }

}