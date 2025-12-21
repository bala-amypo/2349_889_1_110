package com.example.demo.service;

import com.example.demo.entity.ResourceAllocation;
import java.util.List;

public interface ResourceAllocationService {
    ResourceAllocation save(ResourceAllocation allocation);
    List<ResourceAllocation> getAll();
}
