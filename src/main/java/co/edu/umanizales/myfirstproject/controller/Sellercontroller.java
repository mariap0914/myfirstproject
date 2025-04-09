package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.Location;
import co.edu.umanizales.myfirstproject.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/seller")
public class Sellercontroller {
    @GetMapping
    public Seller Getseller(){
        Location Manizales = new Location("Manizales","17001");
        Location Pereira = new Location("Pereira","1600");
        Location Medellin = new Location("Medellin","67001");
        Location Armenia = new Location("Armenia","63001");
        Location suiza = new Location("suiza","18001");

        Seller maria = new Seller("10002635",(byte) 15, "mar", "clavijo", Manizales, 'f');
        Seller paulina = new Seller("1235698", (byte) 25, "paulina", "salas",Pereira, 'f' );
        Seller jose = new Seller("1235698",(byte) 19, "jose", "mesa",Medellin, 'm' );
        Seller alex = new Seller("1235698",(byte) 12, "alex", "cardona", Armenia, 'm' );
        Seller juan = new Seller("1235698", (byte) 37, "juan", "salazar",suiza , 'm' );



        return maria;

    }

}
