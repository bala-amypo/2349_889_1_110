package com.example.demo.service;

import com.example.demo.entity.ResourceAllocation;
import java.util.List;

public interface ResourceAllocationService {

    ResourceAllocation autoAllocate(Long requestId);

    // ✅ Add this
    ResourceAllocation getAllocation(Long id);

    List<ResourceAllocation> getAllAllocations();
}
