package com.xzy.spring.label.scoped_proxy;

public class SingletonBean {

    private PrototypeBean prototypeBean;

    public void printTime() {
        prototypeBean.printTime();
    }

    public void setPrototype(PrototypeBean prototype) {
        this.prototypeBean = prototype;
    }

}
