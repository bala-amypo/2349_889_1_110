package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/allocations")
public class ResourceAllocationController {

    @GetMapping
    public String allocationsInfo() {
        return "Resource Allocation API";
    }
}
