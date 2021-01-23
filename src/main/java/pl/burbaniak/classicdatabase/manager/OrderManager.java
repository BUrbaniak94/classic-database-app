package pl.burbaniak.classicdatabase.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.burbaniak.classicdatabase.dao.OrderRepo;
import pl.burbaniak.classicdatabase.dao.entity.Order;
import pl.burbaniak.classicdatabase.dto.OrderDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderManager {

    private OrderRepo orderRepo;

    @Autowired
    public OrderManager(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public List<OrderDto> findAll (){
        return orderRepo.findAll()
                .stream()
                .map(OrderDto::from)
                .collect(Collectors.toList());
    }

    public Optional<OrderDto> findById(Long id){
        return orderRepo.findById(id).map(OrderDto::from);
    }

    public Order addOrder(Order order){
        return orderRepo.save(order);
    }

    public void deleteOrder(Long id){
        orderRepo.deleteById(id);
    }
}
