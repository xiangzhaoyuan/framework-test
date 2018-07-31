package com.xzy.spring.interfaces.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class PostProcessorB implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.startsWith("testBean")) {
            System.out.println("PostProcessorB--postProcessBeforeInitialization--" + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.startsWith("testBean")) {
            System.out.println("PostProcessorB--postProcessAfterInitialization--" + beanName);
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }

}
