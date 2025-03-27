package co.edu.umanizales.myfirstproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Seller {


    private String identification;
    private byte age;
    private String name;
    private String lastname;
    private Location city;
    private char gender;



}
