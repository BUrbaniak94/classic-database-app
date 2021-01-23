package pl.burbaniak.classicdatabase.manager;


import org.junit.jupiter.api.Test;
import pl.burbaniak.classicdatabase.dao.entity.Payment;
import pl.burbaniak.classicdatabase.dao.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PaymentManagerTest {

    PaymentManager paymentManage;

    @Test
    public void test (){
    //given
        //when
        //then

       Optional<Product> productOpt = getPayment().flatMap(this::getProduct);
       Optional<Optional<Product>> productOptMap = getPayment().map(this::getProduct);

       List<String> stringList = List.of("XX\nXX","Z\nZZZ");
       System.out.print(stringList.stream().map(String::toUpperCase).collect(Collectors.toList()));
       System.out.print("WWWWWWW");
        System.out.print(stringList.stream().flatMap(this::getChar).collect(Collectors.toList()));
    }

    Stream<String> getChar(String el){
        return el.lines();
    }

    Optional<Payment> getPayment(){
        return Optional.empty();
    }

    Optional<Product> getProduct(Payment payment){
        return Optional.empty();
    }

}
