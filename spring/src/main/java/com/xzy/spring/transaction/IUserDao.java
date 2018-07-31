package com.xzy.spring.transaction;

import java.util.List;

public interface IUserDao {

    public User selectUserById(int id);

    public List<User> selectUsersByName(String userName);

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

}
