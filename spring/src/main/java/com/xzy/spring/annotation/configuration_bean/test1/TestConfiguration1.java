package com.xzy.spring.annotation.configuration_bean.test1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * "@Configuration"标注在类上，相当于把该类作为spring的xml配置文件中的<beans>，作用为：配置spring容器(应用上下文)
 */
@Configuration
public class TestConfiguration1 {

    public TestConfiguration1() {
        System.out.println("TestConfiguration1 Spring容器启动初始化...");
    }

    /**
     * 1、@Bean标注在方法上(返回某个实例的方法)，等价于spring的xml配置文件中的<bean>，作用为：注册bean对象
     * 2、@Bean注解注册bean，同时可以指定初始化和销毁方法
     * 3、@Bean注解在返回实例的方法上，如果未通过@Bean指定bean的名称，则默认与标注的方法名相同
     * 4、@Bean注解默认作用域为单例singleton作用域，可通过@Scope(“prototype”)设置为原型作用域
     */
    @Bean(name = "testBean1", initMethod = "init", destroyMethod = "destroy")
    @Scope("prototype")
    public TestBean1 testBean() {
        return new TestBean1();
    }

}
