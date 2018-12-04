package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.model.User;

import java.util.List;

public interface UserService {
    void deleteUser(String username);
    void saveUser(User user);
    User getUser(String username);
    List<User> getUsers();
}
