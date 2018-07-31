package com.xzy.spring.annotation.configuration_bean.test2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * "@Configuration"标注在类上，相当于把该类作为spring的xml配置文件中的<beans>，作用为：配置spring容器(应用上下文)
 * 既然@Bean的作用是注册bean对象，那么完全可以使用@Component、@Controller、@Service、@Repository等注解注册bean，当然需要配置@ComponentScan注解进行自动扫描。
 */
@Configuration
@ComponentScan(basePackages = "com.xzy.spring.annotation.configuration_bean.test2")
public class TestConfiguration2 {

    public TestConfiguration2() {
        System.out.println("TestConfiguration2 Spring容器启动初始化...");
    }

}
