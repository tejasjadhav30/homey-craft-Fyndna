package com.fyndna.project.ProductService.repository;


import com.fyndna.project.ProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product>findProductsBySellerEmail(String sellerEmail);

   // Integer getQuantity(String productId);
    List<Product> getAllProductByName(String name);
    List<Product> getAllProductByCategory(String category);
    List<Product> getAllProductByBrand(String brand);

}
