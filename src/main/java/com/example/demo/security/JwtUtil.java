package com.example.demo.security;

import java.util.Base64;
import java.util.HashMap;

public class JwtUtil {

    private final String secret;
    private final long validityMs;

    public JwtUtil(String secret, long validityMs) {
        this.secret = secret;
        this.validityMs = validityMs;
    }

    public String generateToken(Long userId, String email, String role) {
        long expiry = System.currentTimeMillis() + validityMs;
        String payload = userId + "|" + email + "|" + role + "|" + expiry;

        return Base64.getEncoder().encodeToString(payload.getBytes())
                + "." +
               Base64.getEncoder().encodeToString(secret.getBytes());
    }

    // ✅ RETURN TYPE CHANGED
    public Claims parseClaims(String token) {
        try {
            String[] parts = token.split("\\.");
            if (parts.length != 2) {
                throw new RuntimeException("Invalid token");
            }

            String decoded = new String(Base64.getDecoder().decode(parts[0]));
            String[] values = decoded.split("\\|");

            long expiry = Long.parseLong(values[3]);
            if (System.currentTimeMillis() > expiry) {
                throw new RuntimeException("Token expired");
            }

            Claims claims = new Claims(values[1]);
            claims.put("userId", Long.parseLong(values[0]));
            claims.put("role", values[2]);

            return claims;

        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }

    // ✅ Custom Claims class with getSubject()
    public static class Claims extends HashMap<String, Object> {
        private final String subject;

        public Claims(String subject) {
            this.subject = subject;
        }

        public String getSubject() {
            return subject;
        }
    }
}
