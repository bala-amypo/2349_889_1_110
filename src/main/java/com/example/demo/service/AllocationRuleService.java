package com.example.demo.service;

import com.example.demo.entity.AllocationRule;
import java.util.List;

public interface AllocationRuleService {
    AllocationRule createRule(AllocationRule rule);
    AllocationRule getRule(Long id);
    List<AllocationRule> getAllRules();
    AllocationRule updateRule(Long id, AllocationRule rule);
    void deleteRule(Long id);
}
