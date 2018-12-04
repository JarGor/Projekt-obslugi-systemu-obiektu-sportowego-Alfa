package com.ztbd.sportsfacility.controller;

import com.ztbd.sportsfacility.model.User;
import com.ztbd.sportsfacility.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User addUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @DeleteMapping("/users/{username}")
    public void deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
    }

    @GetMapping("/users/{username}")
    public User getUser(@PathVariable String username) {
        return userService.getUser(username);
    }
}
