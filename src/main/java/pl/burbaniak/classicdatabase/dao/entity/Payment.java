package pl.burbaniak.classicdatabase.dao.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "payments")
@NoArgsConstructor @Data
public class Payment {

    @EmbeddedId
    private PaymentCompositeId paymentCompositeId;
    private Timestamp paymentDate;
    private double amount;
    @ManyToOne
    @JoinColumn (name = "customerNumber", insertable = false, updatable = false)
    private Customer customer;

    public Payment(PaymentCompositeId paymentCompositeId, Timestamp paymentDate, double amount) {
        this.paymentCompositeId = paymentCompositeId;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public PaymentCompositeId getPaymentCompositeId() {
        return paymentCompositeId;
    }
}
