package com.example.demo.repository;

import org.springframework.data.jpa.JpaRepository;
import com.example.entity.ResourceAllocation;

public interface ResourceAllocationRuleRepository extends JpaRepository<ResourceAllocation,Long>{
    
}