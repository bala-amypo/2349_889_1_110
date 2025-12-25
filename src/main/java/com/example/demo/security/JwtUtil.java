package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.*;

public class JwtUtil {

    private final String secret;
    private final long expiry;

    public JwtUtil(String secret, long expiry) {
        this.secret = secret;
        this.expiry = expiry;
    }

    public String generateToken(Long id, String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiry))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims parseClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
}
