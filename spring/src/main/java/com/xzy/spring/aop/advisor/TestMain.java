package com.xzy.spring.aop.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    private static final String XML_PATH = "aop/advisor/application-context.xml";

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext(XML_PATH);
        Fireable tank = ctx.getBean("tank", Fireable.class);
        tank.attack("敌人");

    }

}
