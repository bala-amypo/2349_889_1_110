package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String role;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "requestedBy")
    private List<ResourceRequest> requests;

    public User() {}

    public User(String fullName, String email, String role) {
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.createdAt = LocalDateTime.now();
    }

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // getters & setters
}
