package pl.burbaniak.classicdatabase.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.burbaniak.classicdatabase.dao.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
}
