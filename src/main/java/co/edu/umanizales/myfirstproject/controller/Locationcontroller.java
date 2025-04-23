package co.edu.umanizales.myfirstproject.controller;


import co.edu.umanizales.myfirstproject.model.Location;
import co.edu.umanizales.myfirstproject.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/location")
public class Locationcontroller {

    @Autowired
    private LocationService locationService;
    @GetMapping
    public  List<Location> getLocations() {
        return locationService.getLocations();


    }
     @GetMapping(path = "/{code}")
    public Location getLocation(@PathVariable String code) {
        return locationService.getLocationsByCode(code);
     }

    @GetMapping(path = "/states")
    public List<Location> getLocationsByStates(){
        return locationService.getStates();
     }





}
