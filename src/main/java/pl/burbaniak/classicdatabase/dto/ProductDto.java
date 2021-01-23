package pl.burbaniak.classicdatabase.dto;

import lombok.Builder;
import lombok.Value;
import pl.burbaniak.classicdatabase.dao.entity.Product;

@Value
@Builder
public class ProductDto {
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private int quantityInStock;
    private double buyPrice;
    private double MSRP;

    public static ProductDto from(Product product){
        return builder().productCode(product.getProductCode())
                .productName(product.getProductName())
                .productLine(product.getProductLine())
                .productScale(product.getProductScale())
                .productVendor(product.getProductVendor())
                .productDescription(product.getProductDescription())
                .quantityInStock(product.getQuantityInStock())
                .buyPrice(product.getBuyPrice())
                .MSRP(product.getMSRP())
                .build();
    }
}
