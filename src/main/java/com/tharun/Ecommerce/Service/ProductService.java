package com.tharun.Ecommerce.Service;

import com.tharun.Ecommerce.Model.ProductModel;
import com.tharun.Ecommerce.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public  void saveProduct(ProductModel product){
        productRepo.save(product);
    }

    public List<ProductModel> getAllProducts() {
       return productRepo.findAll();
    }

    public Optional<ProductModel> findbyid(int id) {
       return productRepo.findById(id);
    }

    public void deleteByid(int id) {
        productRepo.deleteById(id);
    }
}
