package com.xzy.spring.interfaces.beanPostProcessor;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestMain {

    private static final String XML_PATH = "interfaces/beanPostProcessor/application-context.xml";

    public static void main(String[] args) {

        /**
         * ApplicationContext会自动检测在配置文件中实现了BeanPostProcessor接口的所有bean。
         * 并把他们注册为后置处理器，然后在容器创建bean的适当时候调用它。
         */
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(XML_PATH);

        /**
         * 而使用BeanFactory实现的时候，bean后置处理器必须通过代码显式的去注册，
         * 在IOC容器集成体系中ConfigurableBeanFactory接口中定义了注册方法addBeanPostProcessor。
         */
        /*Resource resource = new ClassPathResource(XML_PATH);
        DefaultListableBeanFactory context = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions(resource);
        PostProcessorA processorA = new PostProcessorA();
        context.addBeanPostProcessor(processorA);
        PostProcessorB processorB = new PostProcessorB();
        context.addBeanPostProcessor(processorB);*/

        TestBean1 testBean1 = (TestBean1) context.getBean("testBean1");
        testBean1.execute();

        TestBean2 testBean2 = (TestBean2) context.getBean("testBean2");
        testBean2.execute();

        context.close();
    }

}
