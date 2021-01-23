package pl.burbaniak.classicdatabase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.burbaniak.classicdatabase.dao.entity.Order;
import pl.burbaniak.classicdatabase.dao.entity.Product;
import pl.burbaniak.classicdatabase.dto.ProductDto;
import pl.burbaniak.classicdatabase.manager.ProductManager;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product-srv")
public class ProductController {

    private ProductManager productManager;

    @Autowired
    public ProductController(ProductManager productManager) {
        this.productManager = productManager;
    }

    @GetMapping("/products/{productCode}")
    public ResponseEntity<Optional<ProductDto>> findById(@PathVariable String productCode){
        return new ResponseEntity<>(productManager.findById(productCode), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productManager.addProduct(product),HttpStatus.OK);
    }

    @RequestMapping("/products")
    public ResponseEntity<List<ProductDto>> getAll(){
        return  new ResponseEntity<>(productManager.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/products")
    public ResponseEntity<String> deleteProductById(@PathVariable String productCode){
        productManager.deleteProduct(productCode);
        return new ResponseEntity<>(productCode,HttpStatus.OK);
    }
}
