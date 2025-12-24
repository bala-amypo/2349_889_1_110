package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;
import java.time.LocalDateTime;
import java.util.List;
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    java.util.Optional<User> findByEmail(String email);
}
