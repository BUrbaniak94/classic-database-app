package pl.burbaniak.classicdatabase.dao.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode @ToString
public class Employee {

    @Id
    @GeneratedValue
    private Long employeeNumber;
    private String firstName;
    private String lastName;
    private String extension;
    private String email;
    private String officeCode;
    private String reportsTo;
    private String jobTitle;

    public Employee(Long employeeNumber, String firstName, String lastName, String extension, String email, String officeCode, String reportsTo, String jobTitle) {
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
