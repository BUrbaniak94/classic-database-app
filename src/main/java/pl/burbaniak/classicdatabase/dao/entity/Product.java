package pl.burbaniak.classicdatabase.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor @Data
public class Product {

    @Id
    @GeneratedValue
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private int quantityInStock;
    private double buyPrice;
    private double MSRP;
    @OneToMany (mappedBy = "product")
    private List<OrderDetails> orderDetails = new ArrayList<>();
    @ManyToOne
    @JoinColumn (name = "productLine",insertable = false, updatable = false)
    private ProductLine mappedProductLine;


    public Product(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, int quantityInStock, double buyPrice, double MSRP) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.MSRP = MSRP;
    }
}
