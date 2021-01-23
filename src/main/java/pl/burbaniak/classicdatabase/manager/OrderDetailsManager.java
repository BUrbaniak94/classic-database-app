package pl.burbaniak.classicdatabase.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.burbaniak.classicdatabase.dao.OrderDetailsRepo;
import pl.burbaniak.classicdatabase.dao.entity.OrderDetails;
import pl.burbaniak.classicdatabase.dao.entity.OrderDetailsCompositeId;
import pl.burbaniak.classicdatabase.dto.OrderDetailsDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderDetailsManager {

    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    public OrderDetailsManager(OrderDetailsRepo orderDetailsRepo) {
        this.orderDetailsRepo = orderDetailsRepo;
    }

    public List<OrderDetailsDto> findAll (){
        return orderDetailsRepo.findAll()
                .stream()
                .map(OrderDetailsDto::from)
                .collect(Collectors.toList());
    }

    public Optional<OrderDetailsDto> findOrderDetailsById (Long orderNumber, String productCode){
        return orderDetailsRepo.findById(OrderDetailsCompositeId.of(orderNumber,productCode))
                .map(OrderDetailsDto::from);
    }

    public OrderDetails addOrderDetails (OrderDetails orderDetails){
        return orderDetailsRepo.save(orderDetails);
    }

    public void deleteOrderDetailsById (Long orderNumber, String productCode){
        orderDetailsRepo.deleteById(OrderDetailsCompositeId.of(orderNumber,productCode));
    }
}
