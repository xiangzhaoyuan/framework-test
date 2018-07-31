package com.xzy.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IOrderService orderService;

    @Override
    public User getUserById(int id) {
        User user = userDao.selectUserById(id);
        List<Order> orders = orderService.getOrdersByUserId(user.getId());
        user.setOrders(orders);
        return user;
    }

    @Override
    public List<User> getUsersByName(String userName) {
        return userDao.selectUsersByName(userName);
    }

    @Override
    public void addUser(User user) {
        userDao.insertUser(user);
        Integer id = user.getId();
        List<Order> orders = user.getOrders();
        for (Order order : orders) {
            order.setUserId(id);
            orderService.addOrder(order);
        }
    }

    @Override
    public void modifyUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void removeUser(int id) {
        userDao.deleteUser(id);
    }

}
