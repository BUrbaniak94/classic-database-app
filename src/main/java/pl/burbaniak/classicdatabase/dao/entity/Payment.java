package pl.burbaniak.classicdatabase.dao.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "payments")
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode @ToString
public class Payment {

    @EmbeddedId
    private PaymentCompositeId paymentCompositeId;
    private Timestamp paymentDate;
    private double amount;

    public Payment(PaymentCompositeId paymentCompositeId, Timestamp paymentDate, double amount) {
        this.paymentCompositeId = paymentCompositeId;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public PaymentCompositeId getPaymentCompositeId() {
        return paymentCompositeId;
    }
}
