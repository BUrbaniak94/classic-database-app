package pl.burbaniak.classicdatabase.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.burbaniak.classicdatabase.dao.entity.Payment;
import pl.burbaniak.classicdatabase.dao.entity.PaymentCompositeId;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, PaymentCompositeId> {
}
