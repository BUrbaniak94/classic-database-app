package pl.burbaniak.classicdatabase.dto;

import lombok.Builder;
import lombok.Value;
import pl.burbaniak.classicdatabase.dao.entity.Payment;

import java.sql.Timestamp;

@Value
@Builder
public class PaymentDto {

     Long customerNumber;
     String checkNumber;
     Timestamp paymentDate;
     double amount;

    public static PaymentDto from(Payment payment) {
        return builder()
                .customerNumber(payment.getPaymentCompositeId().getCustomerNumber())
                .checkNumber(payment.getPaymentCompositeId().getCheckNumber())
                .paymentDate(payment.getPaymentDate())
                .amount(payment.getAmount())
                .build();

    };
}
