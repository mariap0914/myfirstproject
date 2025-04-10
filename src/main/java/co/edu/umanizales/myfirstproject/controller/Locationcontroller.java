package co.edu.umanizales.myfirstproject.controller;


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
    LocationService locationService;

    public void LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public String mostrarArchivo(){

        locationService.leerArchivo ("C:\\Users\\clavi\\Downloads\\locations.csv");


        StringBuilder contenido = new StringBuilder();
        try (BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\clavi\\Downloads\\locations.csv"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                contenido.append(linea).append("<br>");
            }
        } catch (IOException e) {
            return "Error al leer el archivo: " + e.getMessage();
        }
        return contenido.toString();
    }

}
