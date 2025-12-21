package com.example.demo.service;

import com.example.demo.entity.AllocationRule;
import java.util.List;

public interface AllocationRuleService {
    AllocationRule saveRule(AllocationRule rule);
    List<AllocationRule> getAllRules();
}
