package pl.burbaniak.classicdatabase.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.burbaniak.classicdatabase.dao.CustomerRepo;
import pl.burbaniak.classicdatabase.dao.entity.Customer;
import pl.burbaniak.classicdatabase.dto.CustomerDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerManager {

    private CustomerRepo customerRepo;

    @Autowired
    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<CustomerDto> findAll(){
        return customerRepo.findAll()
                .stream()
                .map(CustomerDto::from)
                .collect(Collectors.toList());
    }

    public Optional<CustomerDto> findById (Long id){
        return customerRepo.findById(id).map(CustomerDto::from);
    }

    public Customer addCustomer (Customer customer)
    {return customerRepo.save(customer);}

    public void deleteCustomer (Long id){
        customerRepo.deleteById(id);
    }

}
