package pl.burbaniak.classicdatabase.dto;

import lombok.Builder;
import lombok.Value;
import pl.burbaniak.classicdatabase.dao.entity.Employee;

@Value
@Builder
public class EmployeeDto {

    private Long employeeNumber;
    private String firstName;
    private String lastName;
    private String extension;
    private String email;
    private Long officeCode;
    private String reportsTo;
    private String jobTitle;

    public static EmployeeDto from (Employee employee){
        return builder().employeeNumber(employee.getEmployeeNumber())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .extension(employee.getExtension())
                .email(employee.getEmail())
                .officeCode(employee.getOfficeCode())
                .reportsTo(employee.getReportsTo())
                .jobTitle(employee.getJobTitle())
                .build();
    }
}
