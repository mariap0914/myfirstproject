package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.Location;
import co.edu.umanizales.myfirstproject.service.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@RestController
@RequestMapping(path = "location")
public class Locationcontroller {

    @GetMapping
    public String getLocation(){

        //CREAMOS OBJETO
        LocationService archivo  = new LocationService();
        archivo.leerArchivo("C:\\Users\\clavi\\Downloads\\locations.csv");


        return "";
    }

}
