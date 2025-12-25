package com.example.demo.controller;

import com.example.demo.entity.AllocationRule;
import com.example.demo.service.AllocationRuleService;
import com.example.demo.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class AllocationRuleController {

    private final AllocationRuleService ruleService;
    public AllocationRuleController(AllocationRuleService ruleService) { this.ruleService = ruleService; }

    @Operation(summary = "Create allocation rule")
    @PostMapping
    public ResponseEntity<AllocationRule> create(@RequestBody AllocationRule rule) {
        return ResponseEntity.ok(ruleService.createRule(rule));
    }

    @Operation(summary = "Get all rules")
    @GetMapping
    public ResponseEntity<List<AllocationRule>> getAll() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }

    @Operation(summary = "Get rule by ID")
    @GetMapping("/{id}")
    public ResponseEntity<AllocationRule> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ruleService.getRule(id));
    }
}
