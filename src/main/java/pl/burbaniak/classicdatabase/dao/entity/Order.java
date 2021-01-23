package pl.burbaniak.classicdatabase.dao.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode @ToString
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long orderNumber;
    private Timestamp orderDate;
    private Timestamp requiredDate;
    private Timestamp shippedDate;
    private String status;
    private String comments;
    private Long customerNumber;

    public Order(Long orderNumber, Timestamp orderDate, Timestamp requiredDate, Timestamp shippedDate, String status, String comments, Long customerNumber) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }
}

