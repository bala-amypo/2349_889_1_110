package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public User registerUser(User user) {
        if (repo.existsByEmail(user.getEmail()))
            throw new IllegalArgumentException("Email already exists");

        if (user.getRole() == null)
            user.setRole("USER");

        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public User getUser(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
