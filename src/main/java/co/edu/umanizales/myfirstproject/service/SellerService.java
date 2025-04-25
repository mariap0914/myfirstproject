package co.edu.umanizales.myfirstproject.service;
import co.edu.umanizales.myfirstproject.model.Location;
import co.edu.umanizales.myfirstproject.model.Seller;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
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
public class SellerService {

    private final LocationService locationService;
    private List<Seller> sellers = new ArrayList<>(); // Inicializamos la lista
    @Value("${seller.filename}") // Corregido el uso del archivo CSV desde la configuración
    private String sellersFilename;

    public SellerService(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostConstruct
    public void readSellersFromCSV() throws IOException, URISyntaxException {
        // Obtenemos la ruta del archivo
        Path pathFile = Paths.get(ClassLoader.getSystemResource(sellersFilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1); // Saltamos la primera línea (cabeceras)

            // Leemos todas las filas del CSV
            while ((line = csvReader.readNext()) != null) {
                String identification = line[0];
                String name = line[1];
                String lastName = line[2];
                char gender = line[3].charAt(0);
                byte age = Byte.parseByte(line[4]);
                Location city = locationService.getLocationByName(line[5]);

                sellers.add(new Seller(identification, name, lastName, gender, age, city));

            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Seller> getAllSellers() {
        return sellers;
    }
}










