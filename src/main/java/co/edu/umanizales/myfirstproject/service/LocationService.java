package co.edu.umanizales.myfirstproject.service;

import co.edu.umanizales.myfirstproject.model.Location;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Service
@Getter
public class LocationService {
    private List<Location> locations;
    @Value("DIVIPOLA-_C_digos_municipios_20250422.csv")
    private String locationsFilename;

     @PostConstruct
    public void readLocationsFromCVS() throws IOException, URISyntaxException {
         locations = new ArrayList<>();
         locations.add(new Location("05", "ANTIOQUIA"));
         locations.add(new Location("17","CALDAS"));
         locations.add(new Location("66","RISARALDA"));
         locations.add(new Location("91","AMAZONAS"));
         locations.add(new Location("08","ATLANTICO"));
         locations.add(new Location("11","BOGOTA"));
         locations.add(new Location("13","BOLIVAR"));
         locations.add(new Location("15","BOYACA"));
         locations.add(new Location("18","CAQUETA"));
         locations.add(new Location("19","CAUCA"));
         locations.add(new Location("85","CASANARE"));
         locations.add(new Location("20","CESAR"));
         locations.add(new Location("70","SUCRE"));
         locations.add(new Location("73","TOLIMA"));
         locations.add(new Location("76","VALLE"));
         locations.add(new Location("99","VICHADA"));
         locations.add(new Location("97","VAUPES"));
         locations.add(new Location("81","ARAUCA"));
         Path pathFile = Paths.get(ClassLoader.getSystemResource(locationsFilename).toURI());

         try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))){
             String [] line;
             csvReader.skip(1);
             //leertodas las filas del csv
             while ((line = csvReader.readNext()) !=null){
                 locations.add(new Location(line[2],line[3]));
             }
         } catch (IOException e) {
             e.printStackTrace();
             throw e; //Lanza la excepcion para que pueda manejarse en la capa superior si es necesario


         } catch (CsvValidationException e) {
             throw new RuntimeException(e);
         }

     }

   public Location getLocationsByCode(String code) {
         for (Location location : locations) {
             if (location.getCode().equals(code)) {
                 return location;
             }
         }
         return null;
     }
     public List<Location> getStates() {
         List<Location> states = new ArrayList<>();
         for (Location location : locations) {
             if(location.getCode().length() ==2){
                 states.add(location);
             }


         }
         return states;
     }



    public List<Location> getCapitals() {
        List<Location> capitals = new ArrayList<>();
        for (Location location : locations) {
            if (location.getCode().length() == 5) {
                capitals.add(location);
            }
        }
        return capitals;
    }

    public List<Location> getLocationsByInitialLetters(String letters) {
        List<Location> result = new ArrayList<>();
        for (Location location : locations) {
            if (location.getDescription().toLowerCase().startsWith(letters.toLowerCase())) {
                result.add(location);
            }
        }
        return result;
    }

    public Location getLocationByName(String name) {
        for (Location location : locations) {
            if (location.getDescription().equalsIgnoreCase(name)) {
                return location;
            }
        }
        return null;
    }

    public Location getStateByCode(String code) {
        for (Location location : locations) {
            if (location.getCode().length() == 2 && location.getCode().equals(code)) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getLocationsByStateCode(String stateCode) {
        List<Location> result = new ArrayList<>();
        for (Location location : locations) {
            if (location.getCode().startsWith(stateCode) && location.getCode().length() > 2) {
                result.add(location);
            }
        }
        return result;
    }




}










