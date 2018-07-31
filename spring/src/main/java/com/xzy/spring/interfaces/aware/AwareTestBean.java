package com.xzy.spring.interfaces.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 实现BeanNameAware接口的Bean，在Bean加载的过程中可以获取到该Bean的id
 * 实现ApplicationContextAware接口的Bean，在Bean加载的过程中可以获取到Spring的ApplicationContext，ApplicationContext是Spring应用上下文，从ApplicationContext中可以获取包括任意的Bean在内的大量Spring容器内容和信息
 * 实现BeanFactoryAware接口的Bean，在Bean加载的过程中可以获取到加载该Bean的BeanFactory
 */
public class AwareTestBean implements BeanNameAware, ApplicationContextAware, BeanFactoryAware, BeanClassLoaderAware, InitializingBean {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;
    private String name;
    private ClassLoader classLoader;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("设置ApplicationContext:" + applicationContext.getClass().getName());

        FootballPlayer footballPlayer = applicationContext.getBean("footballPlayer", FootballPlayer.class);
        System.out.println("applicationContext修改前:" + footballPlayer);

        footballPlayer.setName("Jerry");
        footballPlayer.setTeam("China");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("设置BeanFactory:" + beanFactory.getClass().getName());
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
        System.out.println("设置BeanName:" + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
        System.out.println("设置ClassLoader:" + classLoader.getClass().getName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        FootballPlayer footballPlayer = applicationContext.getBean("footballPlayer", FootballPlayer.class);
        System.out.println("afterPropertiesSet获取:" + footballPlayer);
    }

}
