package pl.burbaniak.classicdatabase.dto;

import lombok.Builder;
import lombok.Value;
import pl.burbaniak.classicdatabase.dao.entity.ProductLine;

@Value
@Builder
public class ProductLineDto {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private String image;

    public static ProductLineDto from(ProductLine productLine){
        return builder().productLine(productLine.getProductLine())
                .textDescription(productLine.getTextDescription())
                .htmlDescription(productLine.getHtmlDescription())
                .image(productLine.getImage())
                .build();
    }

}
