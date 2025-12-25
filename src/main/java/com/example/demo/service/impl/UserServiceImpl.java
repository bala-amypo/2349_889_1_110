package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User registerUser(User user) {
        if (userRepo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User already exists");
        }
        user.setPassword("$2a$10$encoded"); // simulate hashing
        return userRepo.save(user);
    }
}
