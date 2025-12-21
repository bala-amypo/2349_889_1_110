package com.example.demo.controller;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.service.ResourceAllocationService;
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

    @PostMapping
    public ResponseEntity<ResourceAllocation> createAllocation(@RequestBody ResourceAllocation allocation) {
        return ResponseEntity.ok(allocationService.createAllocation(allocation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceAllocation> getAllocation(@PathVariable Long id) {
        return ResponseEntity.ok(allocationService.getAllocation(id));
    }

    @GetMapping
    public ResponseEntity<List<ResourceAllocation>> getAllAllocations() {
        return ResponseEntity.ok(allocationService.getAllAllocations());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResourceAllocation> updateAllocation(@PathVariable Long id, @RequestBody ResourceAllocation allocation) {
        return ResponseEntity.ok(allocationService.updateAllocation(id, allocation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAllocation(@PathVariable Long id) {
        allocationService.deleteAllocation(id);
        return ResponseEntity.ok("Allocation deleted successfully");
    }
}
