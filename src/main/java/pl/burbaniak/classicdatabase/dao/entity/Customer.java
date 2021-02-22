package pl.burbaniak.classicdatabase.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@NoArgsConstructor @Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Long salesRepEmployeeNumber;
    private double creditLimit;
    @ManyToOne
    @JoinColumn( name="salesRepEmployeeNumber", referencedColumnName = "employeeNumber" ,
            insertable = false, updatable = false)
    private Employee employee;
    @OneToMany (mappedBy = "customer")
    private List<Payment> payments = new ArrayList<>();
    @OneToMany (mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    public Customer(Long customerNumber, String customerName, String contactLastName, String contactFirstName, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, Long salesRepEmployeeNumber, double creditLimit) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
        this.creditLimit = creditLimit;
    }
}

