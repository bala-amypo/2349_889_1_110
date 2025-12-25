package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.entity.ResourceAllocation;
import com.example.demo.entity.ResourceRequest;
import com.example.demo.repository.ResourceAllocationRepository;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceAllocationService;

import java.util.List;

public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private final ResourceRequestRepository requestRepo;
    private final ResourceRepository resourceRepo;
    private final ResourceAllocationRepository allocationRepo;

    public ResourceAllocationServiceImpl(ResourceRequestRepository requestRepo,
                                         ResourceRepository resourceRepo,
                                         ResourceAllocationRepository allocationRepo) {
        this.requestRepo = requestRepo;
        this.resourceRepo = resourceRepo;
        this.allocationRepo = allocationRepo;
    }

    @Override
    public ResourceAllocation autoAllocate(Long requestId) {
        ResourceRequest request = requestRepo.findById(requestId).orElseThrow();
        List<Resource> resources = resourceRepo.findByResourceType(request.getResourceType());

        if (resources.isEmpty()) {
            throw new RuntimeException("No resource available");
        }

        ResourceAllocation allocation = new ResourceAllocation();
        allocation.setRequest(request);
        allocation.setResource(resources.get(0));

        return allocationRepo.save(allocation);
    }

    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return allocationRepo.findAll();
    }
}
