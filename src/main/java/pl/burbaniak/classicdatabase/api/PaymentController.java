package pl.burbaniak.classicdatabase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.burbaniak.classicdatabase.dao.entity.Payment;
import pl.burbaniak.classicdatabase.dto.PaymentDto;
import pl.burbaniak.classicdatabase.manager.PaymentManager;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment-srv")
public class PaymentController {

    private final PaymentManager paymentManager;

    @Autowired
    public PaymentController(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    @GetMapping("/payments/{customerNumber}")
    public ResponseEntity<Optional<PaymentDto>> findById(@PathVariable("customerNumber") Long customerNumber,
                                                      @PathParam("checkNumber") String checkNumber){
        return new ResponseEntity<>(paymentManager.findById(customerNumber, checkNumber), HttpStatus.OK);
    }

    @PostMapping("/payments")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment){
        return new ResponseEntity<>(paymentManager.addPayment(payment),HttpStatus.OK);
    }

    @RequestMapping("/payments")
    public ResponseEntity<List<PaymentDto>> getAll(){
        return  new ResponseEntity<>(paymentManager.findAll(),HttpStatus.OK);
    }

    @DeleteMapping ("/payments")
    public ResponseEntity<Long> deletePaymentById(@PathParam("customerNumber") Long customerNumber,
                                                  @PathParam("checkNumber") String checkNumber){
        paymentManager.deletePaymentById(customerNumber,checkNumber);
        return new ResponseEntity<>(customerNumber,HttpStatus.OK);
    }
}
