package com.xzy.spring.transaction;

import java.util.List;

public interface IOrderService {

    public List<Order> getOrdersByUserId(Integer userId);

    public Order getOrderById(Integer id);

    public void addOrder(Order order);

    public void addOrders(List<Order> orders);

    public void modifyOrder(Order order);

    public void removeOrderById(Integer id);

    public void removeOrdersByUserId(Integer userId);

}
