package pl.burbaniak.classicdatabase.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.burbaniak.classicdatabase.dao.ProductLineRepo;
import pl.burbaniak.classicdatabase.dao.entity.Product;
import pl.burbaniak.classicdatabase.dao.entity.ProductLine;
import pl.burbaniak.classicdatabase.dto.ProductLineDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductLineManager {

    private ProductLineRepo productLineRepo;

    @Autowired
    public ProductLineManager(ProductLineRepo productLineRepo) {
        this.productLineRepo = productLineRepo;
    }

    public List<ProductLineDto> findAll (){
        return productLineRepo.findAll()
                .stream()
                .map(ProductLineDto::from)
                .collect(Collectors.toList());
    }

    public Optional<ProductLineDto> findById(String id){
        return productLineRepo.findById(id).map(ProductLineDto::from);
    }

    public ProductLine addProductLine(ProductLine productLine){
        return productLineRepo.save(productLine);
    }

    public void deleteProductLine(String id){
        productLineRepo.deleteById(id);
    }
}
