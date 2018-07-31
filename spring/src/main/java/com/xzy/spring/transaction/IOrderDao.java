package com.xzy.spring.transaction;

import java.util.List;

public interface IOrderDao {

    public List<Order> selectOrdersByUserId(Integer userId);

    public Order selectOrderById(Integer id);

    public void insertOrder(Order order);

    public void updateOrder(Order order);

    public void deleteOrderById(Integer id);

    public void deleteOrdersByUserId(Integer userId);

}
