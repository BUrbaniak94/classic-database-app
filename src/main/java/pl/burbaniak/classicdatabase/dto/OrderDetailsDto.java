package pl.burbaniak.classicdatabase.dto;

import lombok.Builder;
import lombok.Value;
import pl.burbaniak.classicdatabase.dao.entity.OrderDetails;

@Value
@Builder
public class OrderDetailsDto {

    private Long orderNumber;
    private String productCode;
    private int quantityOrdered;
    private double priceEach;
    private int orderLineNumber;

    public static OrderDetailsDto from(OrderDetails orderDetails){
        return builder().orderNumber(orderDetails.getOrderDetailsCompositeId().getOrderNumber())
                .productCode(orderDetails.getOrderDetailsCompositeId().getProductCode())
                .quantityOrdered(orderDetails.getQuantityOrdered())
                .priceEach(orderDetails.getPriceEach())
                .orderLineNumber(orderDetails.getOrderLineNumber())
                .build();
    }


}
