package com.xzy.spring.interfaces.applicationListener;

import org.springframework.context.ApplicationEvent;

public class EmailEvent extends ApplicationEvent {

    private static final long serialVersionUID = 6756443973410041686L;

    private String address;
    private String text;

    public EmailEvent(Object source, String address, String text) {
        super(source);
        this.address = address;
        this.text = text;
        System.out.println("EmailEvent constructor, source: " + source.getClass().getSimpleName() + ", address: " + address + ", text: " + text);
    }

    @Override
    public String toString() {
        return "EmailEvent{address=" + address + ", text=" + text + "}";
    }
}
