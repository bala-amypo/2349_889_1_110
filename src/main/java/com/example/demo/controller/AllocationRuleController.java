package com.example.demo.controller;

import com.example.demo.entity.AllocationRule;
import com.example.demo.service.AllocationRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
@Tag(name = "Allocation Rule")
public class AllocationRuleController {

    private final AllocationRuleService ruleService;

    public AllocationRuleController(AllocationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public AllocationRule create(@RequestBody AllocationRule rule) {
        return ruleService.createRule(rule);
    }

    @GetMapping("/{name}")
    public AllocationRule get(@PathVariable String name) {
        return ruleService.getRule(name);
    }
}
