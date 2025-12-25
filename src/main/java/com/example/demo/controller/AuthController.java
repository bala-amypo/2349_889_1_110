package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ApiResponse register(@RequestBody User user) {
        try {
            User saved = userService.registerUser(user);
            return new ApiResponse(true, "User registered successfully", saved);
        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage(), null);
        }
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody AuthRequest request) {
        try {
            User user = userService.getUserByEmail(request.getEmail());
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                throw new RuntimeException("Invalid credentials");
            }

            String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
            AuthResponse response = new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
            return new ApiResponse(true, "Login successful", response);
        } catch (Exception e) {
            return new ApiResponse(false, e.getMessage(), null);
        }
    }
}
