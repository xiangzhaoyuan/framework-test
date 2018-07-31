package com.xzy.spring.interfaces.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;

/**
 * Spring IoC容器允许BeanFactoryPostProcessor在容器实例化任何bean之前读取bean的定义(配置元数据)，并可以修改它。
 * 同时可以定义多个BeanFactoryPostProcessor，通过设置"order"属性来确定各个BeanFactoryPostProcessor执行顺序。
 * <p>
 * 在Spring中内置了一些BeanFactoryPostProcessor实现类：
 * org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
 * org.springframework.beans.factory.config.PropertyOverrideConfigurer
 * org.springframework.beans.factory.config.CustomEditorConfigurer：用来注册自定义的属性编辑器
 */
public class MyFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println("definitionName:" + definitionName);
            if (!"footballPlayer".equals(definitionName)) {
                continue;
            }
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(definitionName);
            MutablePropertyValues pv = beanDefinition.getPropertyValues();

            PropertyValue name = pv.getPropertyValue("name");
            TypedStringValue nameValue = (TypedStringValue) name.getValue();

            PropertyValue team = pv.getPropertyValue("team");
            TypedStringValue teamValue = (TypedStringValue) team.getValue();

            System.out.println("old value---name:" + nameValue.getValue() + ", team:" + teamValue.getValue());

            pv.addPropertyValue("name", "Jerry");
            pv.addPropertyValue("team", "USA");

            beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        }
    }
}
