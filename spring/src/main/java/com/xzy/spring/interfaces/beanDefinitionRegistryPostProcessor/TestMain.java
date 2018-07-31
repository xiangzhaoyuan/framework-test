package com.xzy.spring.interfaces.beanDefinitionRegistryPostProcessor;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class TestMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        /*TestBean testBean = (TestBean) context.getBean("testBean");
        System.out.println(testBean.getName());*/

        Map<String, Object> map = context.getBeansWithAnnotation(HelloAnnotation.class);
        System.out.println(map);

        context.close();
    }

}
