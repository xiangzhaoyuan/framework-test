package com.xzy.spring.annotation.autowired_resource.test1;

import org.springframework.stereotype.Component;

@Component
public class Benz implements Car {

    @Override
    public void run() {
        System.out.println("benz running!");
    }

}