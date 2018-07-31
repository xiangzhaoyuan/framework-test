package com.xzy.spring.annotation.autowired_resource.test1;

import org.springframework.stereotype.Component;

/**
 * Created by wb-xzy262218 on 2018/6/5.
 */
@Component
public class Man implements Human {

    @Override
    public void speak() {
        System.out.println("man speaking!");
    }

    @Override
    public void walk() {
        System.out.println("man walking!");
    }

}
