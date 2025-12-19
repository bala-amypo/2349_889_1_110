package com.example.demo.service;


import org.springframework.stereotype.Service;
import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import java.util.List;


@Service
public class ResourceService {
private final ResourceRepository repo;


public ResourceService(ResourceRepository repo) {
this.repo = repo;
}


public Resource createResource(Resource r) {
if (repo.existsByResourceName(r.getResourceName()))
throw new RuntimeException("Resource already exists");
return repo.save(r);
}


public Resource getResource(Long id) {
return repo.findById(id).orElseThrow();
}


public List<Resource> getAllResources() {
return repo.findAll();
}
}