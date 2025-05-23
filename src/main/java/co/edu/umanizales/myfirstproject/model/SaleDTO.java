package co.edu.umanizales.myfirstproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class SaleDTO {
    private String seller; // Cédula
    private String store;
    private List<ProductSale> products;
    private LocalDate dateSale;
}
