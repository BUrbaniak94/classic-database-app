package pl.burbaniak.classicdatabase.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.burbaniak.classicdatabase.dao.ProductRepo;
import pl.burbaniak.classicdatabase.dao.entity.Order;
import pl.burbaniak.classicdatabase.dao.entity.Product;
import pl.burbaniak.classicdatabase.dto.ProductDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductManager {

    private ProductRepo productRepo;

    @Autowired
    public ProductManager(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<ProductDto> findAll (){
        return productRepo.findAll()
                .stream()
                .map(ProductDto::from)
                .collect(Collectors.toList());
    }

    public Optional<ProductDto> findById(String id){
        return productRepo.findById(id).map(ProductDto::from);
    }

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public void deleteProduct(String id){
        productRepo.deleteById(id);
    }
}
