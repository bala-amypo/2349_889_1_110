package com.example.demo.service;

import com.example.demo.entity.AllocationRule;
import java.util.List;

public interface AllocationRuleService {

    AllocationRule createRule(AllocationRule rule);

    List<AllocationRule> getAllRules();
}
