package co.edu.umanizales.myfirstproject.controller;

import co.edu.umanizales.myfirstproject.model.TypeDoc;
import co.edu.umanizales.myfirstproject.model.TypeProduct;
import co.edu.umanizales.myfirstproject.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/parameter")
public class ParameterController {
    @Autowired
    private ParameterService parameterService;

    @GetMapping("/typedocs")
    public List<TypeDoc> getTypeDocs() {
        return parameterService.getTypeDocs();
    }

    @GetMapping("/typeproducts")
    public List<TypeProduct> getTypeProducts() {
        return parameterService.getTypeProducts();
    }
}
