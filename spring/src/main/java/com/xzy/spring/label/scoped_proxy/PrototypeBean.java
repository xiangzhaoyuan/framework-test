package com.xzy.spring.label.scoped_proxy;

import java.util.Date;

public class PrototypeBean {

    private Long timeMillis;

    public PrototypeBean() {
        timeMillis = (new Date()).getTime();
    }

    public void printTime() {
        System.out.println(this + " " + timeMillis);
    }

}
