package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ResourceRequestService;
import java.util.List;

public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final ResourceRequestRepository reqRepo;
    private final UserRepository userRepo;

    public ResourceRequestServiceImpl(ResourceRequestRepository reqRepo, UserRepository userRepo) {
        this.reqRepo = reqRepo;
        this.userRepo = userRepo;
    }

    public ResourceRequest createRequest(Long userId, ResourceRequest r) {
        User u = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        if (r.getStartTime().isAfter(r.getEndTime()))
            throw new IllegalArgumentException("Invalid time");

        r.setRequestedBy(u);
        r.setStatus("PENDING");
        return reqRepo.save(r);
    }

    public List<ResourceRequest> getRequestsByUser(Long userId) {
        return reqRepo.findByRequestedBy_Id(userId);
    }

    public ResourceRequest updateRequestStatus(Long id, String status) {
        ResourceRequest r = reqRepo.findById(id).orElseThrow(() -> new RuntimeException("Request not found"));
        r.setStatus(status);
        return reqRepo.save(r);
    }
}
