package pl.burbaniak.classicdatabase.dao.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor @Data
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
    @ManyToOne
    @JoinColumn(name="customerNumber", insertable = false, updatable = false)
    private Customer customer;
    @OneToMany (mappedBy = "order")
    private List<OrderDetails> orderDetails = new ArrayList<>();


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

