package com.xzy.spring.annotation.propertySource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("annotation/propertySource/init.properties")
public class SpringConfig {

    @Autowired
    private Environment env;

    @Bean
    public TestBean testBean() {
        String name = env.getProperty("testBean.name");
        TestBean testBean = new TestBean(name);
        return testBean;
    }

}
