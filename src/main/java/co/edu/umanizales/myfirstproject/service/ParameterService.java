package co.edu.umanizales.myfirstproject.service;

import co.edu.umanizales.myfirstproject.model.TypeDoc;
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
public class ParameterService {

    private List<TypeDoc> typeDocs = new ArrayList<>();
    private List<TypeProduct> typeProducts = new ArrayList<>();

    @Value("${typedoc_file}")
    private String typeDocFilename;

    @Value("${typeproduct_file}")
    private String typeProductFilename;

    @PostConstruct
    public void loadParameters() throws IOException, URISyntaxException {
        loadTypeDocs();
        loadTypeProducts();
    }

    private void loadTypeDocs() throws IOException, URISyntaxException {
        Path pathFile = Paths.get(ClassLoader.getSystemResource(typeDocFilename).toURI());
        try (CSVReader reader = new CSVReader(new FileReader(pathFile.toString()))) {
            reader.skip(1);
            String[] line;
            while ((line = reader.readNext()) != null) {
                typeDocs.add(new TypeDoc(line[0], line[1]));
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadTypeProducts() throws IOException, URISyntaxException {
        Path pathFile = Paths.get(ClassLoader.getSystemResource(typeProductFilename).toURI());
        try (CSVReader reader = new CSVReader(new FileReader(pathFile.toString()))) {
            reader.skip(1);
            String[] line;
            while ((line = reader.readNext()) != null) {
                typeProducts.add(new TypeProduct(line[0], line[1]));
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public TypeProduct getTypeProductByCode(String code) {
        for (TypeProduct tp : typeProducts) {
            if (tp.getCode().equals(code)) {
                return tp;
            }
        }
        return null;
    }
}