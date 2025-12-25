package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.ResourceService;
import java.util.List;

public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository repo;

    public ResourceServiceImpl(ResourceRepository repo) {
        this.repo = repo;
    }

    public Resource createResource(Resource r) {
        if (r.getResourceType() == null || r.getCapacity() == null || r.getCapacity() < 1)
            throw new IllegalArgumentException("Invalid resource");

        if (repo.existsByResourceName(r.getResourceName()))
            throw new IllegalArgumentException("Resource exists");

        return repo.save(r);
    }

    public Resource getResource(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Resource not found"));
    }

    public List<Resource> getAllResources() {
        return repo.findAll();
    }
}
