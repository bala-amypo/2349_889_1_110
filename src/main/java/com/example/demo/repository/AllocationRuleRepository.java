package com.example.demo.repository;

import org.springframework.data.jpa.JpaRepository;
import com.example.entity.AllocationRuleRepository;

public interface AllocationRuleRepository extends JpaRepository<AllocationRule,Long>{

}