package com.example.demo.service.impl;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.service.ResourceAllocationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private final List<ResourceAllocation> allocations = new ArrayList<>();

    @Override
    public ResourceAllocation save(ResourceAllocation allocation) {
        allocations.add(allocation);
        return allocation;
    }

    @Override
    public List<ResourceAllocation> getAll() {
        return allocations;
    }
}
