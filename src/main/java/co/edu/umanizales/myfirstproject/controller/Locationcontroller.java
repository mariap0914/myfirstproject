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

    @GetMapping("/capitals")
    public List<Location> getCapitals() {
        return locationService.getCapitals();
    }

    @GetMapping("/letters/{letters}")
    public List<Location> getLocationsByInitialLetters(@PathVariable String letters) {
        return locationService.getLocationsByInitialLetters(letters);
    }

    @GetMapping("/name/{name}")
    public Location getLocationByName(@PathVariable String name) {
        return locationService.getLocationByName(name);
    }

    @GetMapping("/states/{code}")
    public Location getStateByCode(@PathVariable String code) {
        return locationService.getStateByCode(code);
    }

    @GetMapping("/locations/state/{stateCode}")
    public List<Location> getLocationsByStateCode(@PathVariable String stateCode) {
        return locationService.getLocationsByStateCode(stateCode);
    }







}
