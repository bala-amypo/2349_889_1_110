package com.example.demo.controller;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {
    private final ResourceRequestService requestService;
    public ResourceRequestController(ResourceRequestService requestService) { this.requestService = requestService; }

    @Operation(summary = "Create a resource request for a user")
    @PostMapping("/{userId}")
    public ResourceRequest create(@PathVariable Long userId, @RequestBody ResourceRequest request) {
        return requestService.createRequest(userId, request);
    }

    @Operation(summary = "Get requests by user ID")
    @GetMapping("/user/{userId}")
    public List<ResourceRequest> getByUser(@PathVariable Long userId) { return requestService.getRequestsByUser(userId); }

    @Operation(summary = "Update request status")
    @PutMapping("/status/{requestId}")
    public ResourceRequest updateStatus(@PathVariable Long requestId, @RequestBody String status) {
        return requestService.updateRequestStatus(requestId, status);
    }
}
