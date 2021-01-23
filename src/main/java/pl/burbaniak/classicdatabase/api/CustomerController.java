package pl.burbaniak.classicdatabase.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.burbaniak.classicdatabase.dao.entity.Customer;
import pl.burbaniak.classicdatabase.dto.CustomerDto;
import pl.burbaniak.classicdatabase.manager.CustomerManager;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer-srv")
public class CustomerController {

    private CustomerManager customerManager;
    @Autowired
    public CustomerController(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    @GetMapping("/customers/{customerNumber}")
    public ResponseEntity<Optional<CustomerDto>> findById(@PathVariable Long customerNumber){
        return new ResponseEntity<>(customerManager.findById(customerNumber), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerManager.addCustomer(customer),HttpStatus.OK);
    }

    @RequestMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getAll(){
        return  new ResponseEntity<>(customerManager.findAll(),HttpStatus.OK);
    }

    @DeleteMapping ("/customers")
    public ResponseEntity<Long> deleteCustomerById(@PathParam("customerNumber") Long customerNumber){
        customerManager.deleteCustomer(customerNumber);
        return new ResponseEntity<>(customerNumber,HttpStatus.OK);
    }

}
