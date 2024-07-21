package com.tharun.Ecommerce.Repo;

import com.tharun.Ecommerce.Model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel,Integer> {
}
