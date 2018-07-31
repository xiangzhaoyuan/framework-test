package com.xzy.spring.interfaces.beanDefinitionRegistryPostProcessor;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HelloAnnotation {
}
