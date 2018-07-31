package com.xzy.spring.interfaces.classPathBeanDefinitionScanner.one;

import com.xzy.spring.interfaces.classPathBeanDefinitionScanner.HelloAnnotation;

@HelloAnnotation
public class HelloOne {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HelloOne{name=" + name + "}";
    }
}
