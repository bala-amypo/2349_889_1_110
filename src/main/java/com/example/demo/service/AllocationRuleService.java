package com.example.demo.service;


import org.springframework.stereotype.Service;
import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import java.util.List;


@Service
public class AllocationRuleService {
private final AllocationRuleRepository repo;


public AllocationRuleService(AllocationRuleRepository repo) {
this.repo = repo;
}


public AllocationRule createRule(AllocationRule rule) {
if (repo.existsByRuleName(rule.getRuleName()))
throw new RuntimeException("Rule already exists");
return repo.save(rule);
}


public List<AllocationRule> getAllRules() {
return repo.findAll();
}
}