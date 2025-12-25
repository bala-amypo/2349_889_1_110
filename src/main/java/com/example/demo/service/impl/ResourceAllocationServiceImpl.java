package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.entity.ResourceAllocation;
import com.example.demo.entity.ResourceRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ResourceAllocationRepository;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceAllocationService;

import java.util.List;

public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private final ResourceRequestRepository reqRepo;
    private final ResourceRepository resourceRepo;
    private final ResourceAllocationRepository allocRepo;

    public ResourceAllocationServiceImpl(ResourceRequestRepository reqRepo,
                                         ResourceRepository resourceRepo,
                                         ResourceAllocationRepository allocRepo) {
        this.reqRepo = reqRepo;
        this.resourceRepo = resourceRepo;
        this.allocRepo = allocRepo;
    }

    @Override
    public ResourceAllocation autoAllocate(Long requestId) {

        ResourceRequest request = reqRepo.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));

        List<Resource> resources =
                resourceRepo.findByResourceType(request.getResourceType());

        if (resources == null || resources.isEmpty()) {
            throw new IllegalArgumentException("No resource available");
        }

        ResourceAllocation allocation = new ResourceAllocation();
        allocation.setRequest(request);
        allocation.setResource(resources.get(0));
        allocation.setConflictFlag(false);

        return allocRepo.save(allocation);
    }

    @Override
    public ResourceAllocation getAllocation(Long id) {
        return allocRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Allocation not found"));
    }

    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return allocRepo.findAll();
    }
}
