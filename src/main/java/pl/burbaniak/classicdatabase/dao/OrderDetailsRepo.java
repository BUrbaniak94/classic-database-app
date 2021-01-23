package pl.burbaniak.classicdatabase.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.burbaniak.classicdatabase.dao.entity.OrderDetails;
import pl.burbaniak.classicdatabase.dao.entity.OrderDetailsCompositeId;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, OrderDetailsCompositeId> {
}
