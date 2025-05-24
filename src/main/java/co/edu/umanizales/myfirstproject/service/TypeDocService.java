package co.edu.umanizales.myfirstproject.service;

import co.edu.umanizales.myfirstproject.model.TypeDoc;
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
public class TypeDocService {

    private List<TypeDoc> typeDocs = new ArrayList<>();

    @Value("${typedoc_file}")
    private String typeDocFilename;

    @PostConstruct
    public void loadTypeDocsFromCSV() throws IOException, URISyntaxException {
        Path pathFile = Paths.get(ClassLoader.getSystemResource(typeDocFilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1); // Omitir encabezado

            while ((line = csvReader.readNext()) != null) {
                String code = line[0];
                String description = line[1];

                typeDocs.add(new TypeDoc(code, description));
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Error reading TypeDoc CSV", e);
        }
    }

    public List<TypeDoc> getAllTypeDocs() {
        return typeDocs;
    }

    public TypeDoc getTypeDocByCode(String code) {
        for (TypeDoc td : typeDocs) {
            if (td.getCode().equals(code)) {
                return td;
            }
        }
        return null;
    }
}
