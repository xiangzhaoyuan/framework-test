package com.xzy.spring.interfaces.classPathBeanDefinitionScanner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

public class CustomBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        TypeFilter includeFilter = new AnnotationTypeFilter(HelloAnnotation.class);
        scanner.addIncludeFilter(includeFilter);
        String[] basePackages = {"com.xzy.spring.interfaces.classPathBeanDefinitionScanner.one",
                "com.xzy.spring.interfaces.classPathBeanDefinitionScanner.one"};
        scanner.scan(basePackages);
        System.out.println(222);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(111);
    }

}
