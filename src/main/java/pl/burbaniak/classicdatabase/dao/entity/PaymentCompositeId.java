package pl.burbaniak.classicdatabase.dao.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode @ToString
public class PaymentCompositeId  implements Serializable {

    protected Long customerNumber;
    protected String checkNumber;

    private PaymentCompositeId(Long customerNumber, String checkNumber) {
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
    }

    public static PaymentCompositeId of(Long customerNumber, String checkNumber) {
        return new PaymentCompositeId(customerNumber,checkNumber);
    }
}
