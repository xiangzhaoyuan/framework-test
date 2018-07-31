package com.xzy.spring.interfaces.instantiationAwareBeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.TypedStringValue;

import java.beans.PropertyDescriptor;

/**
 * InstantiationAwareBeanPostProcessor接口继承BeanPostProcessor接口，它内部提供了3个方法，再加上BeanPostProcessor接口内部的2个方法，所以实现这个接口需要实现5个方法。
 * InstantiationAwareBeanPostProcessor接口的主要作用在于目标对象的实例化过程中需要处理的事情，包括实例化对象的前后过程以及实例的属性设置。
 * Instantiation表示实例化，Initialization表示初始化；实例化的意思在对象还未生成，初始化的意思在对象已经生成。
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * postProcessBeforeInstantiation方法是最先执行的方法，它在目标对象实例化之前调用，该方法的返回值类型是Object，我们可以返回任何类型的值。
     * 由于这个时候目标对象还未实例化，所以这个返回值可以用来代替原本该生成的目标对象的实例(比如代理对象)。
     * 如果该方法的返回值代替原本该生成的目标对象，后续只有postProcessAfterInitialization方法会调用，其它方法不再调用；否则按照正常的流程走。
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("执行postProcessBeforeInstantiation, beanName:" + beanName);
        /*
        if (beanClass == Action.class) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setCallback(new MyMethodInterceptor());
            Action action = (Action) enhancer.create();
            System.out.println("返回动态代理");
            return action;
        }*/
        return null;
    }

    /**
     * postProcessAfterInstantiation方法在目标对象实例化之后调用，这个时候对象已经被实例化，但是该实例的属性还未被设置，都是null。
     * 因为它的返回值是决定要不要调用postProcessPropertyValues方法的其中一个因素(因为还有一个因素是mbd.getDependencyCheck())；
     * 如果该方法返回false，并且不需要check，那么postProcessPropertyValues就会被忽略不执行；如果返回true，postProcessPropertyValues就会被执行。
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("执行postProcessAfterInstantiation, beanName:" + beanName);
        return true;
    }

    /**
     * postProcessPropertyValues方法对属性值进行修改(这个时候属性值还未被设置，但是我们可以修改原本该设置进去的属性值)。
     * 如果postProcessAfterInstantiation方法返回false，该方法可能不会被调用。可以在该方法内对属性值进行修改。
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("执行postProcessPropertyValues, beanName:" + beanName);
        if (bean instanceof Action) {
            //修改bean中value的属性值
            PropertyValue value = pvs.getPropertyValue("value");
            System.out.println("修改前value：" + ((TypedStringValue) (value.getValue())).getValue());
            value.setConvertedValue("被修改了");
        }
        return pvs;
    }

    /**
     * 父接口BeanPostProcessor的postProcessorBeforeInitialization方法是在bean实例化、依赖注入之后及自定义初始化方法之前调用
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行postProcessBeforeInitialization, beanName:" + beanName);
        return bean;
    }

    /**
     * 父接口BeanPostProcessor的postProcessorAfterInitialization方法是在bean实例化、依赖注入及自定义初始化方法之后调用
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("执行postProcessAfterInitialization, beanName:" + beanName);
        return bean;
    }

}
