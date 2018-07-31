package com.xzy.spring.demo.eshop;

public class NotifyServiceByWeixinImpl implements NotifyService {

    @Override
    public void sendMessage(String message) {
        System.out.println("发送微信短信:" + message);
    }

}
