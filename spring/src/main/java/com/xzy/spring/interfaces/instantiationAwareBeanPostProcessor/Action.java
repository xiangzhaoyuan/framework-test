package com.xzy.spring.interfaces.instantiationAwareBeanPostProcessor;

public class Action {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void doSomething() {
        System.out.println("执行doSomething......");
    }

}
