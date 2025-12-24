package com.example.demo.service.impl;

import com.example.demo.entity.AllocationRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import java.util.List;

public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AllocationRuleRepository repo;

    public AllocationRuleServiceImpl(AllocationRuleRepository repo) {
        this.repo = repo;
    }

    public AllocationRule createRule(AllocationRule r) {
        if (repo.existsByRuleName(r.getRuleName()))
            throw new IllegalArgumentException("exists");
        return repo.save(r);
    }

    public AllocationRule getRule(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
    }

    public List<AllocationRule> getAllRules() {
        return repo.findAll();
    }
}
