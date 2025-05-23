package co.edu.umanizales.myfirstproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Parameter {
    private String code;
    private String description;
}
