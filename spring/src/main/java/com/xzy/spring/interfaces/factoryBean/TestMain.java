package com.xzy.spring.interfaces.factoryBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wb-xzy262218 on 2018/5/31.
 */
public class TestMain {

    private static final String XML_PATH = "interfaces/factoryBean/application-context.xml";

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(XML_PATH);

        /**
         * 当调用getBean("carFactoryBean") 时，Spring通过反射机制发现CarFactoryBean实现了FactoryBean的接口，
         * 这时Spring容器就调用接口方法CarFactoryBean#getObject()方法返回。
         */
        Object object1 = context.getBean("carFactoryBean");
        System.out.println(object1.getClass().getName());
        System.out.println(object1);

        /**
         * 如果希望获取CarFactoryBean的实例，则需要在使用getBean(beanName)方法时在beanName前显示的加上"&"前缀。
         */
        Object object2 = context.getBean("&carFactoryBean");
        System.out.println(object2.getClass().getName());

        context.close();
    }

}
