package com.example.demo.repository;

import com.example.demo.entity.ResourceRequest;
import java.time.LocalDateTime;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRequestRepository extends JpaRepository<ResourceRequest, Long> {
    List<ResourceRequest> findByRequestedBy_Id(Long id);
    List<ResourceRequest> findByStartTimeBetween(LocalDateTime a, LocalDateTime b);
}
