package com.example.demo.repository;

import org.springframework.data.jpa.JpaRepository;
import com.example.entity.Resource;

public interface ResourceRepository extends JpaRepository<Resource,Long>{
    
}