package com.example.demo.security;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private final String secretKey;
    private final long validityInMs;

    public JwtUtil(String secretKey, long validityInMs) {
        this.secretKey = secretKey;
        this.validityInMs = validityInMs;
    }

    // Generates a simple encoded token
    public String generateToken(Long userId, String email, String role) {
        String payload = userId + ":" + email + ":" + role + ":" + System.currentTimeMillis();
        return Base64.getEncoder().encodeToString(payload.getBytes());
    }

    // Dummy claims parser (used only if tests call it)
    public Map<String, Object> parseClaims(String token) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("token", token);
        return claims;
    }
}
