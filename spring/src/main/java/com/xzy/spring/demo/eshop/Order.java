package com.xzy.spring.demo.eshop;

/**
 * Created by wb-xzy262218 on 2018/6/11.
 */
public class Order {

    private NotifyService notifyService;

    /*notifyservice不是在内部new()出来的，
    而是通过指定方法传进来的，也就是我们说的注入。这里是setter注入*/
    public void setNotifyService(NotifyService notifyService) {
        this.notifyService = notifyService;
    }

    public Order() {
    }

    public Order(NotifyService notifyService) {
        this.notifyService = notifyService;
    }

    /*订单支付完成后，系统通知老板*/
    public void paySuccess() {
        notifyService.sendMessage("客户张铁蛋完成订单2017079657付款，共人民币:97.5元");
    }


}
