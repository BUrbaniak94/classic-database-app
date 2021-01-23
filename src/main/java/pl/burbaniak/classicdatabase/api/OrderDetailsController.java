package pl.burbaniak.classicdatabase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.burbaniak.classicdatabase.dao.entity.Order;
import pl.burbaniak.classicdatabase.dao.entity.OrderDetails;
import pl.burbaniak.classicdatabase.dto.OrderDetailsDto;
import pl.burbaniak.classicdatabase.manager.OrderDetailsManager;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderdetails-srv")
public class OrderDetailsController {

    private OrderDetailsManager orderDetailsManager;

    @Autowired
    public OrderDetailsController(OrderDetailsManager orderDetailsManager) {
        this.orderDetailsManager = orderDetailsManager;
    }

    @GetMapping("/orderdetails/{orderNumber}")
    public ResponseEntity<Optional<OrderDetailsDto>> findOrderDetailsById(@PathVariable("orderNumber") Long orderNumber,
                                                                          @PathParam("productCode") String productCode){
        return new ResponseEntity<>(orderDetailsManager.findOrderDetailsById(orderNumber,productCode), HttpStatus.OK);
    }

    @PostMapping("/orderdetails")
    public ResponseEntity<OrderDetails> addOrderDetails(@RequestBody OrderDetails orderDetails){
        return new ResponseEntity<>(orderDetailsManager.addOrderDetails(orderDetails),HttpStatus.OK);
    }

    @RequestMapping("/orderdetails")
    public ResponseEntity<List<OrderDetailsDto>> getAll(){
        return  new ResponseEntity<>(orderDetailsManager.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/orderdetails")
    public ResponseEntity<Long> deleteOrderDetailsById(@PathParam("orderNumber") Long orderNumber,
                                                       @PathParam("productCode") String productCode){
        orderDetailsManager.deleteOrderDetailsById(orderNumber,productCode);
        return new ResponseEntity<>(orderNumber,HttpStatus.OK);
    }
}
