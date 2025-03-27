package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "location")
public class Locationcontroller {

    @GetMapping
    public String getLocation(){


        Location location  = new Location("manizales","17001");

        return "hola";
    }

}
