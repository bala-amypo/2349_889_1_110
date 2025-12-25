package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @GetMapping
    public String resourcesInfo() {
        return "Resource API";
    }
}
