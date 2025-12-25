package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceRequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final ResourceRequestRepository requestRepository;

    public ResourceRequestServiceImpl(ResourceRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public ResourceRequest createRequest(Long userId, ResourceRequest request) {
        // existing logic
        return null;
    }

    @Override
    public ResourceRequest getRequest(Long id) {
        Optional<ResourceRequest> request = requestRepository.findById(id);
        return request.orElse(null);
    }

    @Override
    public List<ResourceRequest> getRequestsByUser(Long userId) {
        // existing logic
        return null;
    }

    @Override
    public ResourceRequest updateRequestStatus(Long requestId, String status) {
        // existing logic
        return null;
    }
}
