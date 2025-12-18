package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

import java.util.List;

public class ResourceRequestService {

    private final ResourceRequestRepository repo;
    private final UserRepository userRepo;

    public ResourceRequestService(ResourceRequestRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public ResourceRequest createRequest(Long userId, ResourceRequest r) {
        r.setRequestedBy(userRepo.findById(userId).orElseThrow());
        return repo.save(r);
    }

    public List<ResourceRequest> getRequestsByUser(Long userId) {
        return repo.findByRequestedBy_Id(userId);
    }

    public ResourceRequest getRequest(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public ResourceRequest updateRequestStatus(Long id, String status) {
        ResourceRequest r = getRequest(id);
        r.setStatus(status);
        return repo.save(r);
    }
}
