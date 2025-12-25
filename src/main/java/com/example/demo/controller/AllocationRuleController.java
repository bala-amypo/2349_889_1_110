package com.example.demo.controller;

import com.example.demo.entity.AllocationRule;
import com.example.demo.service.AllocationRuleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class AllocationRuleController {
    private final AllocationRuleService ruleService;
    public AllocationRuleController(AllocationRuleService ruleService) { this.ruleService = ruleService; }

    @Operation(summary = "Create a new allocation rule")
    @PostMapping
    public AllocationRule create(@RequestBody AllocationRule rule) {
        return ruleService.createRule(rule);
    }

    @Operation(summary = "Get all rules")
    @GetMapping
    public List<AllocationRule> getAll() { return ruleService.getAllRules(); }

    @Operation(summary = "Get rule by ID")
    @GetMapping("/{id}")
    public AllocationRule getById(@PathVariable Long id) { return ruleService.getRule(id); }
}
