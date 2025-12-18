package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

import java.util.List;

public class ResourceAllocationService {

    private final ResourceRequestRepository reqRepo;
    private final ResourceRepository resRepo;
    private final ResourceAllocationRepository allocRepo;

    public ResourceAllocationService(ResourceRequestRepository r1,
                                     ResourceRepository r2,
                                     ResourceAllocationRepository r3) {
        this.reqRepo = r1;
        this.resRepo = r2;
        this.allocRepo = r3;
    }

    public ResourceAllocation autoAllocate(Long requestId) {
        ResourceRequest req = reqRepo.findById(requestId).orElseThrow();
        Resource res = resRepo.findByResourceType(req.getResourceType()).get(0);

        ResourceAllocation alloc = new ResourceAllocation();
        alloc.setRequest(req);
        alloc.setResource(res);
        alloc.setConflictFlag(false);

        return allocRepo.save(alloc);
    }

    public ResourceAllocation getAllocation(Long id) {
        return allocRepo.findById(id).orElseThrow();
    }

    public List<ResourceAllocation> getAllAllocations() {
        return allocRepo.findAll();
    }
}
