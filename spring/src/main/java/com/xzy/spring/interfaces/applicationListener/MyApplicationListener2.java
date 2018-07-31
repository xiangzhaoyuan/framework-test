package com.xzy.spring.interfaces.applicationListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener2 implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof EmailEvent) {
            System.out.println("MyApplicationListener2:" + event);
        }
        System.out.println("MyApplicationListener2 " + event.getClass().getName());
    }

}
