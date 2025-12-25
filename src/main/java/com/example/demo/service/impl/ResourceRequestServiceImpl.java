package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ResourceRequestService;

import java.util.List;

public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final ResourceRequestRepository requestRepo;
    private final UserRepository userRepo;

    public ResourceRequestServiceImpl(ResourceRequestRepository requestRepo,
                                      UserRepository userRepo) {
        this.requestRepo = requestRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ResourceRequest createRequest(Long userId, ResourceRequest request) {
        User user = userRepo.findById(userId).orElseThrow();
        request.setRequestedBy(user);
        request.setStatus("PENDING");
        return requestRepo.save(request);
    }

    @Override
    public List<ResourceRequest> getRequestsByUser(Long userId) {
        return requestRepo.findByRequestedBy_Id(userId);
    }

    @Override
    public ResourceRequest updateRequestStatus(Long requestId, String status) {
        ResourceRequest request = requestRepo.findById(requestId).orElseThrow();
        request.setStatus(status);
        return requestRepo.save(request);
    }
}
