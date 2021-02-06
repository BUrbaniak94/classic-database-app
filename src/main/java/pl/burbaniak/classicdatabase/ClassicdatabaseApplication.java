package pl.burbaniak.classicdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import pl.burbaniak.classicdatabase.dao.CustomerRepo;
import pl.burbaniak.classicdatabase.dao.entity.Customer;
import pl.burbaniak.classicdatabase.manager.CustomerManager;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ClassicdatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassicdatabaseApplication.class, args);
	}
}