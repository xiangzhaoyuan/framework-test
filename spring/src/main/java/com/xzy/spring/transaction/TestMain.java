package com.xzy.spring.transaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    private static final String XML_PATH = "transaction/spring/spring-mybatis.xml";


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(XML_PATH);

        IUserService userService = (IUserService) context.getBean("userService");
        IOrderService orderService = (IOrderService) context.getBean("orderService");
        addUserTest(userService);
        //addOrderTest(orderService);
        context.close();
    }

    private static void addUserTest(IUserService userService) {
        User user = new User();
        user.setUsername("li4");
        user.setPassword("123456");
        user.setAge(18);
        user.setGender(0);

        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setOrderNo("34643486733");
        order.setOrderStatus(1);
        order.setProductCount(32);
        order.setProductAmountTotal(6854.55);
        orders.add(order);
        user.setOrders(orders);

        userService.addUser(user);
        System.out.println(user);
        System.out.println(orders);
    }

    private static void selectUserByIdTest(IUserService userService) {
        User user = userService.getUserById(1);
        System.out.println(user);
        System.out.println(user.getOrders());
    }

    private static void modifyUserTest(IUserService userService) {
        User user1 = userService.getUserById(2);
        System.out.println(user1);
        user1.setPassword("654321");
        user1.setAge(20);
        userService.modifyUser(user1);
        User user2 = userService.getUserById(2);
        System.out.println(user2);
    }

    private static void getUsersByNameTest(IUserService userService) {
        List<User> users = userService.getUsersByName("zhang3");
        System.out.println(users);
    }

    private static void addOrderTest(IOrderService orderService) {
        Order order = new Order();
        order.setOrderNo("792757676442638");
        order.setUserId(1);
        order.setOrderStatus(1);
        order.setProductCount(43);
        order.setProductAmountTotal(6854.55);
        orderService.addOrder(order);
    }

    private static void getOrderByIdTest(IOrderService orderService) {
        Order order = orderService.getOrderById(1);
        System.out.println(order);
    }

    public static void getOrdersByUserIdTest(IOrderService orderService) {
        List<Order> orders = orderService.getOrdersByUserId(1);
        System.out.println(orders);
    }

    private static void modifyOrderTest(IOrderService orderService) {
        Order order = orderService.getOrderById(2);
        order.setOrderNo("8555416685425");
        order.setOrderStatus(2);
        order.setProductCount(20);
        order.setProductAmountTotal(6325.0);
        orderService.modifyOrder(order);
    }

    private static void removeOrderByIdTest(IOrderService orderService) {
        orderService.removeOrderById(3);
    }

    private static void removeOrdersByUserIdTest(IOrderService orderService) {
        orderService.removeOrdersByUserId(2);
    }

}
