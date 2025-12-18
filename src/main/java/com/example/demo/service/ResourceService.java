package com.example.demo.service;

import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.exception.ValidationException;

import java.util.List;

public class ResourceService {

    private final ResourceRepository repo;

    public ResourceService(ResourceRepository repo) {
        this.repo = repo;
    }

    public Resource createResource(Resource r) {
        if (repo.existsByResourceName(r.getResourceName()))
            throw new ValidationException("resource exists");
        return repo.save(r);
    }

    public Resource getResource(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Resource> getAllResources() {
        return repo.findAll();
    }
}
