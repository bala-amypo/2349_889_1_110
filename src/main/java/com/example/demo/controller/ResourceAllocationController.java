package com.example.demo.controller;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.service.ResourceAllocationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/allocations")
public class ResourceAllocationController {
    private final ResourceAllocationService allocationService;
    public ResourceAllocationController(ResourceAllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @Operation(summary = "Auto allocate a resource")
    @PostMapping("/auto/{requestId}")
    public ResourceAllocation autoAllocate(@PathVariable Long requestId) {
        return allocationService.autoAllocate(requestId);
    }

    @Operation(summary = "Get all allocations")
    @GetMapping
    public List<ResourceAllocation> getAll() { return allocationService.getAllAllocations(); }

    @Operation(summary = "Get allocation by ID")
    @GetMapping("/{id}")
    public ResourceAllocation getById(@PathVariable Long id) {
        return allocationService.getAllocation(id);
    }
}
