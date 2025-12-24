package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String resourceName;

    private String resourceType;

    private Integer capacity;

    private String location;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "resource")
    private List<ResourceAllocation> allocations;

    public Resource() {}

    /* getters & setters */
}
