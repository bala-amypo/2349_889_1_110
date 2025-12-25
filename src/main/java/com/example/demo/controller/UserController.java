package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/register")
    public ApiResponse registerUser(@RequestBody User user) {
        try {
            User saved = userService.registerUser(user);
            return new ApiResponse(true, "User registered successfully", saved);
        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage(), null);
        }
    }

    @GetMapping
    public ApiResponse getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ApiResponse(true, "All users retrieved", users);
    }

    @GetMapping("/{id}")
    public ApiResponse getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUser(id);
            return new ApiResponse(true, "User found", user);
        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage(), null);
        }
    }
}
