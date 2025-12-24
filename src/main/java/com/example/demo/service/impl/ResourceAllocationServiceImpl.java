package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.ResourceAllocationService;
import java.util.List;

public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private final ResourceRequestRepository reqRepo;
    private final ResourceRepository resRepo;
    private final ResourceAllocationRepository allocRepo;

    public ResourceAllocationServiceImpl(ResourceRequestRepository r, ResourceRepository re, ResourceAllocationRepository a) {
        this.reqRepo = r;
        this.resRepo = re;
        this.allocRepo = a;
    }

    public ResourceAllocation autoAllocate(Long requestId) {
        ResourceRequest req = reqRepo.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));

        List<Resource> list = resRepo.findByResourceType(req.getResourceType());
        if (list.isEmpty()) throw new IllegalArgumentException("No resource");

        ResourceAllocation a = new ResourceAllocation();
        a.setResource(list.get(0));
        a.setRequest(req);
        a.setConflictFlag(false);
        return allocRepo.save(a);
    }

    public List<ResourceAllocation> getAllAllocations() {
        return allocRepo.findAll();
    }
}
