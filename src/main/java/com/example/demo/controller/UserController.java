package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @Operation(summary = "Register a new user")
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public List<User> getAll() { return userService.getAllUsers(); }

    @Operation(summary = "Get a user by ID")
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) { return userService.getUser(id); }
}
