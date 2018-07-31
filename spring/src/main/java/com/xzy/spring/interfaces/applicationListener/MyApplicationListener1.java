package com.xzy.spring.interfaces.applicationListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener1 implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof EmailEvent) {
            System.out.println("MyApplicationListener1:" + event);
        }
        System.out.println("MyApplicationListener1 " + event.getClass().getName());
    }

}
