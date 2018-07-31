package com.xzy.spring.annotation.autowired_resource.test1;

import org.springframework.stereotype.Component;

/**
 * Created by wb-xzy262218 on 2018/6/5.
 */
@Component
public class Woman implements Human {

    @Override
    public void speak() {
        System.out.println("woman speaking!");
    }

    @Override
    public void walk() {
        System.out.println("woman walking!");
    }

}
