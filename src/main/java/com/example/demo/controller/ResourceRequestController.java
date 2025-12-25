package com.example.demo.controller;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
@Tag(name = "Resource Request")
public class ResourceRequestController {

    private final ResourceRequestService requestService;

    public ResourceRequestController(ResourceRequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ResourceRequest add(@RequestBody ResourceRequest request) {
        return requestService.addRequest(request);
    }

    @GetMapping("/user/{userId}")
    public List<ResourceRequest> getByUser(@PathVariable Long userId) {
        return requestService.findByUser(userId);
    }

    @PutMapping("/{id}/status/{status}")
    public ResourceRequest updateStatus(
            @PathVariable Long id,
            @PathVariable String status) {
        return requestService.updateStatus(id, status);
    }
}
