package com.example.demo.repository;

import org.springframework.data.jpa.JpaRepository;
import com.example.entity.ResourceRequest;

public interface ResourceRequestRepository extends JpaRepository<ResourceRequest,Long>{
    
}