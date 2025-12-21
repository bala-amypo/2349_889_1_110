package com.example.demo.service;

import com.example.demo.entity.ResourceRequest;
import java.util.List;

public interface ResourceRequestService {
    ResourceRequest save(ResourceRequest request);
    List<ResourceRequest> getAll();
}
