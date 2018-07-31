package com.xzy.spring.demo.eshop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("demo/eshop/application-context.xml");
        Order order = ctx.getBean("order", Order.class);
        order.paySuccess();
    }

}
