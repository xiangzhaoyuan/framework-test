package com.xzy.spring.annotation.propertySource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

public class TestMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestBean testBean = (TestBean) context.getBean("testBean");
        System.out.println(testBean.getName());
        context.close();
        testPropertySource1();
        testPropertySource2();
    }

    /**
     * Environment可以持有一系列的PropertySource，然后在从中获取属性时，其会依次从对应的PropertySource中寻找，当然也包括系统属性和环境变量。
     * 一个Environment中默认会包含两个PropertySource，分别对应于系统属性和环境变量。即默认情况下在只有系统属性和环境变量对应的两个PropertySource时，
     * 如果我们从Environment中获取某属性，将先从系统属性中取，没取到再从环境变量中获取。
     */
    public static void testPropertySource1() {
        ConfigurableApplicationContext context = new GenericApplicationContext();
        ConfigurableEnvironment env = context.getEnvironment();
        String userDir = env.getProperty("user.dir");
        System.out.println(userDir);
        context.close();
    }

    /**
     * 可以往Environment中添加PropertySource对象，之后添加的PropertySource对象就可以用来获取对应的属性
     */
    public static void testPropertySource2() {
        ConfigurableApplicationContext context = new GenericApplicationContext();
        //获取Environment对象
        ConfigurableEnvironment env = context.getEnvironment();
        //获取Environment的PropertySources
        MutablePropertySources propertySources = env.getPropertySources();
        //new一个基于Resource的PropertySource
        ResourcePropertySource rps = null;
        try {
            rps = new ResourcePropertySource(new ClassPathResource("annotation/propertySource/init.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //给当前Environment对象env添加一个PropertySource对象
        propertySources.addFirst(rps);
        String userDir = env.getProperty("user.dir");
        System.out.println(userDir);
        context.close();
    }

}
