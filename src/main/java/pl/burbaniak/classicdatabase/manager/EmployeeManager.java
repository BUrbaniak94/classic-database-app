package pl.burbaniak.classicdatabase.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.burbaniak.classicdatabase.dao.EmployeeRepo;
import pl.burbaniak.classicdatabase.dao.entity.Employee;
import pl.burbaniak.classicdatabase.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeManager {

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeManager(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Optional<EmployeeDto> findById (Long id){
        return employeeRepo.findById(id).map(EmployeeDto::from);
    }

    public List<EmployeeDto> findAll (){
        return employeeRepo.findAll()
                .stream()
                .map(EmployeeDto::from)
                .collect(Collectors.toList());
    }

    public Employee addEmployee(Employee employee){
       return employeeRepo.save(employee);
    }

    public void deleteEmployee (Long id){
        employeeRepo.deleteById(id);
    }

}
