package com.task.api.controller;

import com.task.api.entity.User;
import com.task.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {

        return service.addUser(user);
    }
}