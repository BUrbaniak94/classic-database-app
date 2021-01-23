package pl.burbaniak.classicdatabase.dao.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orderdetails")
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode @ToString
public class OrderDetails {

    @EmbeddedId
    private OrderDetailsCompositeId orderDetailsCompositeId;
    private int quantityOrdered;
    private double priceEach;
    private int orderLineNumber;

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
