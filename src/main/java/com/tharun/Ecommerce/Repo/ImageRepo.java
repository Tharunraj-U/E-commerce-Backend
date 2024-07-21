package com.tharun.Ecommerce.Repo;

import com.tharun.Ecommerce.Model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<ImageModel,Integer> {
}
