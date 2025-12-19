package com.example.demo.controller;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.repository.ResourceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
public class ResourceRequestController {

    @Autowired
    private ResourceRequestRepository resourceRequestRepository;

    // CREATE RESOURCE REQUEST
    @PostMapping
    public ResourceRequest createRequest(@RequestBody ResourceRequest request) {
        return resourceRequestRepository.save(request);
    }

    // GET ALL REQUESTS
    @GetMapping
    public List<ResourceRequest> getAllRequests() {
        return resourceRequestRepository.findAll();
    }

    // GET REQUEST BY ID
    @GetMapping("/{id}")
    public Optional<ResourceRequest> getRequestById(@PathVariable Long id) {
        return resourceRequestRepository.findById(id);
    }

    // UPDATE REQUEST
    @PutMapping("/{id}")
    public ResourceRequest updateRequest(@PathVariable Long id, @RequestBody ResourceRequest updatedRequest) {
        ResourceRequest request = resourceRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ResourceRequest not found"));
        
        request.setResourceName(updatedRequest.getResourceName());
        request.setQuantity(updatedRequest.getQuantity());
        return resourceRequestRepository.save(request);
    }

    // DELETE REQUEST
    @DeleteMapping("/{id}")
    public String deleteRequest(@PathVariable Long id) {
        resourceRequestRepository.deleteById(id);
        return "ResourceRequest deleted successfully!";
    }
}
