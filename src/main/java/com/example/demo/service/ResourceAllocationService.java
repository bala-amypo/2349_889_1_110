package com.example.demo.service;

import com.example.demo.entity.ResourceAllocation;
import java.util.List;

public interface ResourceAllocationService {
    ResourceAllocation createAllocation(ResourceAllocation allocation);
    ResourceAllocation getAllocation(Long id);
    List<ResourceAllocation> getAllAllocations();
    ResourceAllocation updateAllocation(Long id, ResourceAllocation allocation);
    void deleteAllocation(Long id);
}
