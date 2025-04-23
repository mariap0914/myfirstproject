package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/seller")
public class Sellercontroller {
    @GetMapping
    public Location Getseller(){
        Location Manizales = new Location("Manizales","17001");
        Location Pereira = new Location("Pereira","1600");
        Location Medellin = new Location("Medellin","67001");
        Location Armenia = new Location("Armenia","63001");
        Location suiza = new Location("suiza","18001");


        return suiza;
    }

}
