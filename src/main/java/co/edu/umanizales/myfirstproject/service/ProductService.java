package co.edu.umanizales.myfirstproject.service;

import co.edu.umanizales.myfirstproject.model.Product;
import co.edu.umanizales.myfirstproject.model.TypeProduct;
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
public class ProductService {

    private final ParameterService parameterService;
    private List<Product> products = new ArrayList<>();

    @Value("${products_file}")
    private String productFilename;

    public ProductService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    @PostConstruct
    public void loadProductsFromCSV() throws IOException, URISyntaxException {
        Path pathFile = Paths.get(ClassLoader.getSystemResource(productFilename).toURI());
        try (CSVReader reader = new CSVReader(new FileReader(pathFile.toString()))) {
            reader.skip(1);
            String[] line;
            while ((line = reader.readNext()) != null) {
                TypeProduct type = parameterService.getTypeProductByCode(line[3]);
                products.add(new Product(line[0], line[1], Double.parseDouble(line[2]), type));
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
