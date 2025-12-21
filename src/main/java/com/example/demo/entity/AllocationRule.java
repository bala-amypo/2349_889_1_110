package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "allocation_rules")
public class AllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceType;
    private int priority;

    public AllocationRule() {
    }

    public Long getId() { return id; }

    public String getResourceType() { return resourceType; }
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getPriority() { return priority; }
    public void setPriority(int priority) {
        this.priority = priority;
    }
}
