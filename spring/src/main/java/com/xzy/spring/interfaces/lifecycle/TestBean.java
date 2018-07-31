package com.xzy.spring.interfaces.lifecycle;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestBean {

    public TestBean() {
        System.out.println("TestBean");
    }

    public void printTime() {
        System.out.println((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
    }

}
