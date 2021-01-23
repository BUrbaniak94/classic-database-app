package pl.burbaniak.classicdatabase.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.burbaniak.classicdatabase.dao.entity.Order;
import pl.burbaniak.classicdatabase.dto.OrderDto;
import pl.burbaniak.classicdatabase.manager.OrderManager;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-srv")
public class OrderController {

    private OrderManager orderManager;

    @Autowired
    public OrderController(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @GetMapping("/orders/{orderNumber}")
    public ResponseEntity<Optional<OrderDto>> findById(@PathVariable Long orderNumber){
        return new ResponseEntity<>(orderManager.findById(orderNumber), HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderManager.addOrder(order),HttpStatus.OK);
    }

    @RequestMapping("/orders")
    public ResponseEntity<List<OrderDto>> getAll(){
        return  new ResponseEntity<>(orderManager.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/orders")
    public ResponseEntity<Long> deleteOrderById(@PathVariable Long orderNumber){
        orderManager.deleteOrder(orderNumber);
        return new ResponseEntity<>(orderNumber,HttpStatus.OK);
    }
}
