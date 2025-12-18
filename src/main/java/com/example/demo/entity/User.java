package com.example.demo.entity;
import jakarta.persistence.*;

public class User {
    @id
    private Long id;
    private String resourceName;
    private String resourceType;
    private int capacity;
    private String Location;
    private localdate createdAt;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getResourceName() {
        return resourceName;
    }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    public String getResourceType() {
        return resourceType;
    }
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public String getLocation() {
        return Location;
    }
    public void setLocation(String location) {
        Location = location;
    }
    public localdate getCreatedAt() {
        return createdAt;
    }
    public User() {
    }
    public void setCreatedAt(localdate createdAt) {
        this.createdAt = createdAt;
    }
    public User(Long id, String resourceName, String resourceType, int capacity, String location, localdate createdAt) {
        this.id = id;
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.capacity = capacity;
        Location = location;
        this.createdAt = createdAt;
    }


    
}
