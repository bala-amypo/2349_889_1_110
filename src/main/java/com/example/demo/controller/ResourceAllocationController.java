package com.example.demo.controller;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.service.ResourceAllocationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allocations")
public class ResourceAllocationController {

    private final ResourceAllocationService allocationService;
    public ResourceAllocationController(ResourceAllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @Operation(summary = "Auto allocate a resource for a request")
    @PostMapping("/auto/{requestId}")
    public ResponseEntity<ResourceAllocation> autoAllocate(@PathVariable Long requestId) {
        return ResponseEntity.ok(allocationService.autoAllocate(requestId));
    }

    @Operation(summary = "Get all allocations")
    @GetMapping
    public ResponseEntity<List<ResourceAllocation>> getAll() {
        return ResponseEntity.ok(allocationService.getAllAllocations());
    }

    @Operation(summary = "Get allocation by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ResourceAllocation> getById(@PathVariable Long id) {
        return ResponseEntity.ok(allocationService.getAllocation(id));
    }
}
