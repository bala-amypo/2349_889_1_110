package com.example.demo.repository;

import com.example.demo.entity.Resource;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    boolean existsByResourceName(String name);
    List<Resource> findByResourceType(String type);
}
