package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ResourceAllocationRepository extends JpaRepository<ResourceAllocation, Long> {}