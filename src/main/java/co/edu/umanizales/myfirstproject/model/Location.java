package co.edu.umanizales.myfirstproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Location  {
    private String code;
    private String description;

    }


