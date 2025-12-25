package com.example.demo.controller;

import com.example.demo.entity.Resource;
import com.example.demo.service.ResourceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {
    private final ResourceService resourceService;
    public ResourceController(ResourceService resourceService) { this.resourceService = resourceService; }

    @Operation(summary = "Create a new resource")
    @PostMapping
    public Resource create(@RequestBody Resource resource) { return resourceService.createResource(resource); }

    @Operation(summary = "Get all resources")
    @GetMapping
    public List<Resource> getAll() { return resourceService.getAllResources(); }

    @Operation(summary = "Get resource by ID")
    @GetMapping("/{id}")
    public Resource getById(@PathVariable Long id) { return resourceService.getResource(id); }
}
