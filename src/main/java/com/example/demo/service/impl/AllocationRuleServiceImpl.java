package com.example.demo.service.impl;

import com.example.demo.entity.AllocationRule;
import com.example.demo.service.AllocationRuleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final List<AllocationRule> rules = new ArrayList<>();

    @Override
    public AllocationRule createRule(AllocationRule rule) {
        rules.add(rule);
        return rule;
    }

    @Override
    public List<AllocationRule> getAllRules() {
        return rules;
    }
}
