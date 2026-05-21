package com.task.api.service;

import com.task.api.entity.User;
import com.task.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public String addUser(User user) {

        repo.save(user);

        return "User Added Successfully";
    }
}