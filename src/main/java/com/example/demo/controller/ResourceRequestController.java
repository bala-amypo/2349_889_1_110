package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {

    private final ResourceRequestService requestService;
    public ResourceRequestController(ResourceRequestService requestService) { this.requestService = requestService; }

    @Operation(summary = "Create a resource request for a user")
    @PostMapping("/{userId}")
    public ResponseEntity<ResourceRequest> create(@PathVariable Long userId, @RequestBody ResourceRequest request) {
        return ResponseEntity.ok(requestService.createRequest(userId, request));
    }

    @Operation(summary = "Get all requests of a user")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ResourceRequest>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(requestService.getRequestsByUser(userId));
    }

    @Operation(summary = "Get request by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ResourceRequest> getById(@PathVariable Long id) {
        return ResponseEntity.ok(requestService.getRequest(id));
    }

    @Operation(summary = "Update request status")
    @PutMapping("/status/{requestId}")
    public ResponseEntity<ResourceRequest> updateStatus(@PathVariable Long requestId, @RequestParam String status) {
        return ResponseEntity.ok(requestService.updateRequestStatus(requestId, status));
    }
}
