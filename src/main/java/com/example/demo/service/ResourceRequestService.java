package com.example.demo.service;


import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import java.util.List;


@Service
public class ResourceRequestService {
private final ResourceRequestRepository requestRepo;
private final UserRepository userRepo;


public ResourceRequestService(ResourceRequestRepository requestRepo, UserRepository userRepo) {
this.requestRepo = requestRepo;
this.userRepo = userRepo;
}


public ResourceRequest createRequest(Long userId, ResourceRequest req) {
User u = userRepo.findById(userId).orElseThrow();
req.setRequestedBy(u);
return requestRepo.save(req);
}


public List<ResourceRequest> getRequestsByUser(Long userId) {
return requestRepo.findByRequestedBy_Id(userId);
}


public ResourceRequest updateStatus(Long id, String status) {
ResourceRequest r = requestRepo.findById(id).orElseThrow();
r.setStatus(status);
return requestRepo.save(r);
}
}