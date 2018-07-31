package com.xzy.spring.interfaces.beanDefinitionRegistryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.util.Set;

/**
 * BeanDefinitionRegistryPostProcessor中定义的postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
 * 方法可以让我们实现自定义的注册bean定义的逻辑。
 */
public class CustomBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        /*
        RootBeanDefinition testBean = new RootBeanDefinition(TestBean.class);
        MutablePropertyValues propertyValues = testBean.getPropertyValues();
        propertyValues.addPropertyValue("name", "hello");
        registry.registerBeanDefinition("testBean", testBean);//新增Bean定义
        */

        //是否使用默认的filter，使用默认的filter意味着只扫描那些类上拥有Component、Service、Repository或Controller注解的类。
        boolean useDefaultFilters = false;

        //ClassPathScanningCandidateComponentProvider可以根据一定的规则扫描类路径下满足特定条件的Class来作为候选的bean定义
        ClassPathScanningCandidateComponentProvider beanScanner = new ClassPathScanningCandidateComponentProvider(useDefaultFilters);

        /**
         * 通过TypeFilter来指定需要匹配的类和需要排除的类，AnnotationTypeFilter构造方法另外两个参数含义：
         * 指定considerMetaAnnotations="true"时则如果目标类上没有指定的注解，但是目标类上的某个注解上加上了指定的注解则该类也将匹配；
         * 指定considerInterfaces="true"时，则如果对应的类实现的接口上拥有指定的注解时也将匹配。
         * 如果我们需要扫描的目标注解上是加了@Inherited注解的，则如果一个类上没有指定的目标注解，但是其父类拥有对应的注解，则也会被扫描到。
         */
        TypeFilter includeFilter = new AnnotationTypeFilter(HelloAnnotation.class);
        beanScanner.addIncludeFilter(includeFilter);

        String basePackage = "com.xzy.spring.interfaces.beanDefinitionRegistryPostProcessor";
        Set<BeanDefinition> beanDefinitions = beanScanner.findCandidateComponents(basePackage);
        for (BeanDefinition beanDefinition : beanDefinitions) {
            //beanName通常由对应的BeanNameGenerator来生成，比如Spring自带的AnnotationBeanNameGenerator、DefaultBeanNameGenerator等，也可以自己实现。
            String beanName = beanDefinition.getBeanClassName();
            if (beanName.endsWith("TestBean")) {
                MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
                propertyValues.addPropertyValue("name", "hello");
            }
            registry.registerBeanDefinition(beanName, beanDefinition);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //System.out.println(beanFactory.getBean("testBean"));
    }

}
