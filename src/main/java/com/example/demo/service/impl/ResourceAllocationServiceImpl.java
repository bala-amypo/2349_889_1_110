package com.example.demo.service.impl;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.repository.ResourceAllocationRepository;
import com.example.demo.service.ResourceAllocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private final ResourceAllocationRepository allocationRepository;

    public ResourceAllocationServiceImpl(ResourceAllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }

    @Override
    public ResourceAllocation autoAllocate(Long requestId) {
        // existing logic
        return null;
    }

    @Override
    public ResourceAllocation getAllocation(Long id) {
        // Implement the method properly
        Optional<ResourceAllocation> allocation = allocationRepository.findById(id);
        return allocation.orElse(null);
    }

    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return allocationRepository.findAll();
    }
}
