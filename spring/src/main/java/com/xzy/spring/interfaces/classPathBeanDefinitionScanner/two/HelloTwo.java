package com.xzy.spring.interfaces.classPathBeanDefinitionScanner.two;

import com.xzy.spring.interfaces.classPathBeanDefinitionScanner.HelloAnnotation;

@HelloAnnotation
public class HelloTwo {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HelloTwo{name=" + name + "}";
    }
}
