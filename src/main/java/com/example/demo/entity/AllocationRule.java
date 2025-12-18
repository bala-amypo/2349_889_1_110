import com.example.demo.entity;

import jakarta.persistence.*;

public class AssociationRule(){
    @id
    private Long id;
    private String ruleName;
    private int priorityWeight;
    private localdate LocalDatetime;
    
}