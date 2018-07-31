package com.xzy.spring.interfaces.applicationListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class EmailSendAction implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void login(String address, String text) {
        EmailEvent event = new EmailEvent(this.applicationContext, address, text);
        this.applicationContext.publishEvent(event);
    }

}
