package com.springappconsumer.services;


import com.springappconsumer.User;

import java.util.List;

public interface UserService {
    User showUser(Long id);
    void addUser(User user);
    void removeUser(Long id);
    List<User> getUsers();
}

