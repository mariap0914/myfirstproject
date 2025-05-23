package co.edu.umanizales.myfirstproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductSale {
    private String code;
    private int quantity;
    private double subtotal;
}
