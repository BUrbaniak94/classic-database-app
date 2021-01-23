package pl.burbaniak.classicdatabase.dto;

import lombok.Builder;
import lombok.Value;
import pl.burbaniak.classicdatabase.dao.entity.Order;

import java.sql.Timestamp;

@Value
@Builder
public class OrderDto {
    private Long orderNumber;
    private Timestamp orderDate;
    private Timestamp requiredDate;
    private Timestamp shippedDate;
    private String status;
    private String comments;
    private Long customerNumber;

    public static OrderDto from(Order order){
        return builder().orderNumber(order.getOrderNumber())
                .orderDate(order.getOrderDate())
                .requiredDate(order.getRequiredDate())
                .shippedDate(order.getShippedDate())
                .status(order.getStatus())
                .comments(order.getComments())
                .customerNumber(order.getCustomerNumber())
                .build();
    }
}
