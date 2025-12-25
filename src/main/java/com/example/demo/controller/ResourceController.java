package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Resource;
import com.example.demo.service.ResourceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private final ResourceService resourceService;
    public ResourceController(ResourceService resourceService) { this.resourceService = resourceService; }

    @Operation(summary = "Create a resource")
    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody Resource resource) {
        Resource created = resourceService.createResource(resource);
        return ResponseEntity.ok(new ApiResponse(true, "Resource created", created));
    }

    @Operation(summary = "Get all resources")
    @GetMapping
    public ResponseEntity<List<Resource>> getAll() {
        return ResponseEntity.ok(resourceService.getAllResources());
    }

    @Operation(summary = "Get resource by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Resource> getById(@PathVariable Long id) {
        return ResponseEntity.ok(resourceService.getResource(id));
    }
}
