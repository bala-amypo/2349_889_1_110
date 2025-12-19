package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {

    // CREATE
    @PostMapping
    public String createRequest(@RequestBody String request) {
        return "Request created: " + request;
    }

    // READ ALL
    @GetMapping
    public String getAllRequests() {
        return "All requests fetched";
    }

    // READ BY ID
    @GetMapping("/{id}")
    public String getRequestById(@PathVariable int id) {
        return "Request with ID " + id;
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateRequest(@PathVariable int id, @RequestBody String request) {
        return "Request updated with ID " + id;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteRequest(@PathVariable int id) {
        return "Request deleted with ID " + id;
    }
}
