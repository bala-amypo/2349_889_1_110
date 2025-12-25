package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.ResourceService;

import java.util.List;

public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepo;

    public ResourceServiceImpl(ResourceRepository resourceRepo) {
        this.resourceRepo = resourceRepo;
    }

    @Override
    public Resource createResource(Resource resource) {
        if (resource.getResourceName() == null || resource.getResourceType() == null) {
            throw new RuntimeException("Invalid resource");
        }
        if (resourceRepo.existsByResourceName(resource.getResourceName())) {
            throw new RuntimeException("Duplicate resource");
        }
        return resourceRepo.save(resource);
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepo.findAll();
    }
}
