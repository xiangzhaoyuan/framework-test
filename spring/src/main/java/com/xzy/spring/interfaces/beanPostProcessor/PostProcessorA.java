package com.xzy.spring.interfaces.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * BeanPostProcessor接口将对所有的bean都起作用；
 * 接口中两个方法不能返回null，如果返回null那么在后续初始化方法将报空指针异常或者通过getBean()方法获取不到bean实例对象,
 * 因为后置处理器从Spring IoC容器中取出bean实例对象没有再次放回IoC容器中，这会导致后面的后置处理器不再继续回调
 */
public class PostProcessorA implements BeanPostProcessor, Ordered {

    /**
     * 后置处理器的postProcessorBeforeInitialization方法是在bean实例化，依赖注入之后及自定义初始化方法之前调用,
     * 例如：配置文件中bean标签添加init-method属性指定Java类中初始化方法、@PostConstruct注解指定初始化方法、Java类实现InitializingBean接口
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.startsWith("testBean")) {
            System.out.println("PostProcessorA--postProcessBeforeInitialization--" + beanName);
        }
        return bean;
        //return null;
    }

    /**
     * 后置处理器的postProcessorAfterInitialization方法是在bean实例化、依赖注入及自定义初始化方法之后调用
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.startsWith("testBean")) {
            System.out.println("PostProcessorA--postProcessAfterInitialization--" + beanName);
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return 1;
    }

}
