package com.example.demo.service;

import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationRuleService {

    private final AllocationRuleRepository ruleRepository;

    // MUST be this constructor
    public AllocationRuleService(AllocationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public AllocationRule createRule(AllocationRule rule) {
        if (ruleRepository.existsByRuleName(rule.getRuleName())) {
            throw new RuntimeException("Rule already exists");
        }
        if (rule.getPriorityWeight() < 0) {
            throw new RuntimeException("Priority weight must be >= 0");
        }
        return ruleRepository.save(rule);
    }

    public AllocationRule getRule(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    public List<AllocationRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
