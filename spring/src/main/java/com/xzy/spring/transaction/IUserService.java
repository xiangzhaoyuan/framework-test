package com.xzy.spring.transaction;

import java.util.List;

public interface IUserService {

    public User getUserById(int id);

    public List<User> getUsersByName(String userName);

    public void addUser(User user);

    public void modifyUser(User user);

    public void removeUser(int id);

}
