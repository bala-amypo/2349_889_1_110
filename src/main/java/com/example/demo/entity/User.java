package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String fullName;
private String email;
private String role = "USER";
private LocalDateTime createdAt = LocalDateTime.now();
}