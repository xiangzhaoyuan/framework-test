package com.xzy.spring.label.scoped_proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("label/scoped_proxy/application-context.xml");
        SingletonBean singletonBean = ctx.getBean("singletonBean", SingletonBean.class);

        //打印结果对象的地址不一样，说明我们实现了每次调用都能获得新的短生命周期的对象
        singletonBean.printTime();
        singletonBean.printTime();
    }

}
