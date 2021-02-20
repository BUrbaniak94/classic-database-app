package pl.burbaniak.classicdatabase.dao.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orderdetails")
@NoArgsConstructor @Data
public class OrderDetails {

    @EmbeddedId
    private OrderDetailsCompositeId orderDetailsCompositeId;
    private int quantityOrdered;
    private double priceEach;
    private int orderLineNumber;
    @ManyToOne
    @JoinColumn(name="orderNumber", insertable = false, updatable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "productCode", insertable = false, updatable = false)
    private Product product;

    public OrderDetails(OrderDetailsCompositeId orderDetailsCompositeId, int quantityOrdered, double priceEach, int orderLineNumber) {
        this.orderDetailsCompositeId = orderDetailsCompositeId;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }


    public OrderDetailsCompositeId getOrderDetailsCompositeId() {
        return orderDetailsCompositeId;
    }
}
