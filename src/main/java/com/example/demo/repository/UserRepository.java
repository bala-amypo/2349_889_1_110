package com.example.demo.repository;

import org.springframework.data.jpa.JpaRepository;
import com.example.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}