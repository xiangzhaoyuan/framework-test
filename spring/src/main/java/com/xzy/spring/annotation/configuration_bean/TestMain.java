package com.xzy.spring.annotation.configuration_bean;

import com.xzy.spring.annotation.configuration_bean.test1.TestBean1;
import com.xzy.spring.annotation.configuration_bean.test1.TestConfiguration1;
import com.xzy.spring.annotation.configuration_bean.test2.TestBean2;
import com.xzy.spring.annotation.configuration_bean.test2.TestConfiguration2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * "@Configuration"注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
 */
public class TestMain {

    public static void main(String[] args) {

        ApplicationContext context1 = new AnnotationConfigApplicationContext(TestConfiguration1.class);
        TestBean1 testBean1 = (TestBean1) context1.getBean("testBean1");
        testBean1.sayHello();

        ApplicationContext context2 = new AnnotationConfigApplicationContext(TestConfiguration2.class);
        TestBean2 testBean2 = (TestBean2) context2.getBean("testBean2");
        testBean2.sayHello();

    }

}
