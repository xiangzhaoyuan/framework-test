package com.xzy.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED,
        rollbackFor = Exception.class, readOnly = true, timeout = 3)
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Order> getOrdersByUserId(Integer userId) {
        if (true) {
            throw new RuntimeException("exception");
        }
        return orderDao.selectOrdersByUserId(userId);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderDao.selectOrderById(id);
    }

    @Override
    public void addOrder(Order order) {
        if (true) {
            //throw new RuntimeException("exception");
        }
        orderDao.insertOrder(order);
    }

    @Override
    public void addOrders(List<Order> orders) {
        for (Order order : orders) {
            orderDao.insertOrder(order);
        }
    }

    @Override
    public void modifyOrder(Order order) {
        orderDao.updateOrder(order);
    }

    @Override
    public void removeOrderById(Integer id) {
        orderDao.deleteOrderById(id);
    }

    @Override
    public void removeOrdersByUserId(Integer userId) {
        orderDao.deleteOrdersByUserId(userId);
    }

}
