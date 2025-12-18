import com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

public class AssociationRule(){
    @id
    private Long id;
    private String ruleName;
    @PositiveOrZero
    private int priorityWeight;
    private localdate LocalDatetime;

}