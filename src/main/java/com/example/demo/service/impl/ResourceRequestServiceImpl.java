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
    public ResourceRequest save(ResourceRequest request) {
        requests.add(request);
        return request;
    }

    @Override
    public List<ResourceRequest> getAll() {
        return requests;
    }
}
