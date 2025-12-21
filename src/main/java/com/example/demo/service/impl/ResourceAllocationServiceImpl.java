package com.example.demo.service.impl;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.service.ResourceAllocationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    @Override
    public ResourceAllocation autoAllocate(Long requestId) {
        // dummy implementation for now
        return new ResourceAllocation();
    }

    @Override
    public ResourceAllocation getAllocation(Long id) {
        // dummy implementation for now
        return new ResourceAllocation();
    }

    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return new ArrayList<>();
    }
}
