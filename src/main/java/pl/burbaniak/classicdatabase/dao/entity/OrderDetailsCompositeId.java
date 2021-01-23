package pl.burbaniak.classicdatabase.dao.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode @ToString
public class OrderDetailsCompositeId implements Serializable {

    protected Long orderNumber;
    protected String productCode;

    public OrderDetailsCompositeId(Long orderNumber, String productCode) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

    public static OrderDetailsCompositeId of(Long orderNumber, String productCode){
        return new OrderDetailsCompositeId(orderNumber,productCode);
    }

}
