package com.xzy.spring.demo.eshop;

public class NotifyServiceByCellPhoneImpl implements NotifyService {

    @Override
    public void sendMessage(String message) {
        System.out.println("发送手机短信:" + message);
    }

}
