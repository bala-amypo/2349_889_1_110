package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/allocation-rules")
public class AllocationRuleController {

    @GetMapping
    public String allocationRulesInfo() {
        return "Allocation Rule API";
    }
}
