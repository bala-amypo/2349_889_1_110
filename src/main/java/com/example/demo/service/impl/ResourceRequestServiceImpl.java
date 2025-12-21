package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ResourceRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final ResourceRequestRepository requestRepository;
    private final UserRepository userRepository;

    public ResourceRequestServiceImpl(ResourceRequestRepository requestRepository, UserRepository userRepository) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResourceRequest createRequest(Long userId, ResourceRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (request.getStartTime() == null || request.getEndTime() == null || request.getStartTime().isAfter(request.getEndTime())) {
            throw new IllegalArgumentException("Invalid time range");
        }

        if (request.getPurpose() == null || request.getPurpose().isEmpty()) {
            throw new IllegalArgumentException("Purpose is required");
        }

        request.setRequestedBy(user);
        if (request.getStatus() == null) request.setStatus("PENDING");

        return requestRepository.save(request);
    }

    @Override
    public ResourceRequest getRequest(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));
    }

    @Override
    public List<ResourceRequest> getRequestsByUser(Long userId) {
        return requestRepository.findByRequestedById(userId);
    }

    @Override
    public ResourceRequest updateRequest(Long id, ResourceRequest request) {
        ResourceRequest existing = getRequest(id);
        existing.setResourceType(request.getResourceType());
        existing.setStartTime(request.getStartTime());
        existing.setEndTime(request.getEndTime());
        existing.setPurpose(request.getPurpose());
        existing.setStatus(request.getStatus());
        return requestRepository.save(existing);
    }

    @Override
    public void deleteRequest(Long id) {
        requestRepository.delete(getRequest(id));
    }
}
