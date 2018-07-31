package com.xzy.spring.interfaces.messageSource;


import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import java.util.Locale;

public class TestBean implements MessageSourceAware {

    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void printMessage() {
        System.out.println(this.messageSource.getMessage("appName", null, null));
        System.out.println(this.messageSource.getMessage("appName", null, Locale.ENGLISH));
        System.out.println(this.messageSource.getMessage("hello", null, Locale.CHINA));
    }
}
