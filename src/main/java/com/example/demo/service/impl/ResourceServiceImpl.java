package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Resource createResource(Resource resource) {
        if (resourceRepository.existsByResourceName(resource.getResourceName())) {
            throw new IllegalArgumentException("Resource with name exists");
        }
        if (resource.getCapacity() == null || resource.getCapacity() < 1) {
            throw new IllegalArgumentException("Invalid capacity");
        }
        return resourceRepository.save(resource);
    }

    @Override
    public Resource getResource(Long id) {
        return resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @Override
    public Resource updateResource(Long id, Resource resource) {
        Resource existing = getResource(id);
        existing.setResourceName(resource.getResourceName());
        existing.setResourceType(resource.getResourceType());
        existing.setCapacity(resource.getCapacity());
        existing.setLocation(resource.getLocation());
        return resourceRepository.save(existing);
    }

    @Override
    public void deleteResource(Long id) {
        resourceRepository.delete(getResource(id));
    }
}
