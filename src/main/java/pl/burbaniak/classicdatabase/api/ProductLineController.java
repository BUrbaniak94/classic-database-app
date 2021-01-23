package pl.burbaniak.classicdatabase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.burbaniak.classicdatabase.dao.entity.ProductLine;
import pl.burbaniak.classicdatabase.dto.ProductLineDto;
import pl.burbaniak.classicdatabase.manager.ProductLineManager;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productline-srv")
public class ProductLineController {

    private ProductLineManager productLineManager;

    @Autowired
    public ProductLineController(ProductLineManager productLineManager) {
        this.productLineManager = productLineManager;
    }

    @GetMapping("/productlines/{productLine}")
    public ResponseEntity<Optional<ProductLineDto>> findById(@PathVariable("productLine") String productLine){
        return new ResponseEntity<>(productLineManager.findById(productLine), HttpStatus.OK);
    }

    @PostMapping("/productlines")
    public ResponseEntity<ProductLine> addProductLine(@RequestBody ProductLine productLine){
        return new ResponseEntity<>(productLineManager.addProductLine(productLine),HttpStatus.OK);
    }

    @RequestMapping("/productlines")
    public ResponseEntity<List<ProductLineDto>> getAll(){
        return  new ResponseEntity<>(productLineManager.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/productlines")
    public ResponseEntity<String> deleteProductLineById(@PathVariable("productLine") String productLine){
        productLineManager.deleteProductLine(productLine);
        return new ResponseEntity<>(productLine,HttpStatus.OK);
    }
}
