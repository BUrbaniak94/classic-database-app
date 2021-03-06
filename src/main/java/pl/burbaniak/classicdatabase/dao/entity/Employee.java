package pl.burbaniak.classicdatabase.dao.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
@NoArgsConstructor @Data
public class Employee {

    @Id
    @GeneratedValue
    private Long employeeNumber;
    private String firstName;
    private String lastName;
    private String extension;
    private String email;
    private Long officeCode;
    private String reportsTo;
    private String jobTitle;
    @OneToMany(mappedBy = "employee")
    private List<Customer> customers = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name="officeCode",insertable = false,updatable = false)
    private Office office;


    public Employee(Long employeeNumber, String firstName, String lastName, String extension, String email, Long officeCode, String reportsTo, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }
}
