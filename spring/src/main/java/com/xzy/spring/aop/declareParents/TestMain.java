package com.xzy.spring.aop.declareParents;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static final String XML_PATH = "aop/declareParents/application-context.xml";

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(XML_PATH);
        Fireable fighterPlane = ctx.getBean("fighterPlane", Fireable.class);
        System.out.println("==========Interfaces:");
        Class<?>[] interfaces = fighterPlane.getClass().getInterfaces();
        for (Class cls : interfaces) {
            System.out.println(cls.getName());
        }
        System.out.println("==========SuperclassName:" + fighterPlane.getClass().getSuperclass().getName());
        fighterPlane.attack();
        ((CommonParent) fighterPlane).doSomething();
    }

}
