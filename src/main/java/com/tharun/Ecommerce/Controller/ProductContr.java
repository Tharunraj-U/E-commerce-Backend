package com.tharun.Ecommerce.Controller;

import com.tharun.Ecommerce.Model.ProductModel;
import com.tharun.Ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProductContr {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ProductModel product) {
        try {
            productService.saveProduct(product);
            return ResponseEntity.ok("Successful");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public Optional<ProductModel> getByid(@PathVariable("id") int id){

        return productService.findbyid(id);
    }
    @GetMapping("/")
    public List<ProductModel> getAll(){

        return   productService.getAllProducts();

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> DeleteById(@PathVariable("id") int id){
        productService.deleteByid(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
