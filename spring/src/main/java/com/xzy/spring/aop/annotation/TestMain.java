package com.xzy.spring.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static final String XML_PATH = "aop/annotation/application-context.xml";

    public static void main(String[] args) {

        Object target = new Object();

        ApplicationContext ctx = new ClassPathXmlApplicationContext(XML_PATH);
        Fireable fighterPlane = ctx.getBean("fighterPlane", Fireable.class);
        Fireable tank = ctx.getBean("tank", Fireable.class);
        fighterPlane.attack(target);
        System.out.println();
        tank.attack(target);
    }

}
