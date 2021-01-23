package pl.burbaniak.classicdatabase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.burbaniak.classicdatabase.dao.entity.Employee;
import pl.burbaniak.classicdatabase.dto.EmployeeDto;
import pl.burbaniak.classicdatabase.manager.EmployeeManager;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee-srv")
public class EmployeeController {

    private EmployeeManager employeeManager;
    @Autowired
    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping("/employees/{employeeNumber}")
    public ResponseEntity<Optional<EmployeeDto>> findById(@PathVariable Long employeeNumber){
        return new ResponseEntity<>(employeeManager.findById(employeeNumber),HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeManager.addEmployee(employee),HttpStatus.OK);
    }

    @RequestMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAll(){
        return  new ResponseEntity<>(employeeManager.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/employees")
    public ResponseEntity<Long> deleteEmployeeById(@PathParam("employeeNumber") Long employeeNumber){
        employeeManager.deleteEmployee(employeeNumber);
        return new ResponseEntity<>(employeeNumber,HttpStatus.OK);
    }

}
