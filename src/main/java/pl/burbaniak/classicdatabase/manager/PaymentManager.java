package pl.burbaniak.classicdatabase.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.burbaniak.classicdatabase.dao.PaymentRepo;
import pl.burbaniak.classicdatabase.dao.entity.OrderDetails;
import pl.burbaniak.classicdatabase.dao.entity.Payment;
import pl.burbaniak.classicdatabase.dao.entity.PaymentCompositeId;
import pl.burbaniak.classicdatabase.dto.PaymentDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentManager {

    private PaymentRepo paymentRepo;

    @Autowired
    public PaymentManager(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    public List<PaymentDto> findAll() {
        return paymentRepo.findAll()
                .stream()
                .map(PaymentDto::from)
                .collect(Collectors.toList());
    }

    public Optional<PaymentDto> findById(Long customerNumber, String checkNumber) {
        return paymentRepo.findById(PaymentCompositeId.of(customerNumber, checkNumber))
                .map(PaymentDto::from);
    }

    public Payment addPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public void deletePaymentById(Long customerNumber, String checkNumber) {
        paymentRepo.deleteById(PaymentCompositeId.of(customerNumber, checkNumber));
    }
}
