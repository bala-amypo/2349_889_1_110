package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final List<ResourceRequest> requests = new ArrayList<>();

    @Override
    public ResourceRequest createRequest(Long userId, ResourceRequest request) {
        requests.add(request);
        return request;
    }

    @Override
    public List<ResourceRequest> getRequestsByUser(Long userId) {
        return requests;
    }

    @Override
    public ResourceRequest getRequest(Long id) {
        return requests.isEmpty() ? null : requests.get(0);
    }

    @Override
    public ResourceRequest updateRequestStatus(Long requestId, String status) {
        ResourceRequest r = getRequest(requestId);
        if (r != null) {
            r.setStatus(status);
        }
        return r;
    }
}
