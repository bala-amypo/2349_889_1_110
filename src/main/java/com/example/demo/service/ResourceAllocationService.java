package com.example.demo.service;


import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.List;


@Service
public class ResourceAllocationService {
private final ResourceRequestRepository reqRepo;
private final ResourceRepository resRepo;
private final ResourceAllocationRepository allocRepo;


public ResourceAllocationService(ResourceRequestRepository reqRepo, ResourceRepository resRepo,
ResourceAllocationRepository allocRepo) {
this.reqRepo = reqRepo;
this.resRepo = resRepo;
this.allocRepo = allocRepo;
}


public ResourceAllocation autoAllocate(Long requestId) {
ResourceRequest req = reqRepo.findById(requestId).orElseThrow();
Resource res = resRepo.findAll().get(0);
ResourceAllocation alloc = new ResourceAllocation();
alloc.setRequest(req);
alloc.setResource(res);
alloc.setConflictFlag(false);
return allocRepo.save(alloc);
}


public List<ResourceAllocation> getAll() {
return allocRepo.findAll();
}
}