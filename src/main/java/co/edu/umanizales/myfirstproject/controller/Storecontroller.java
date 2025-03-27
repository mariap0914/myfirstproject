package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.Location;
import co.edu.umanizales.myfirstproject.model.Store;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/store")


public class Storecontroller {
    @GetMapping
    public String hello() {
        Store store = new Store("capricho","17001", "calle 6", "manizales");
        return "Hola lindos";

    }
}
