import com.example.demo.entity;

import jakarta.persistence.*;

public class Resource(){
    @id
    private Long id;
    private String resourceName;
    private String resourceType;
    private int capacity;
    private String location;
    private localdate createdAt;
    
}