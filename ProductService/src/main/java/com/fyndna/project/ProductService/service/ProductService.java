package com.fyndna.project.ProductService.service;


import com.fyndna.project.ProductService.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    //Integer getQuantity(String productId);

    Product addProduct(Product product);

    Optional<Product> getProductById(Long productId);

    boolean deleteProduct(Long productId);

    Product updateProduct(Long id, Product product);

    List<Product> getAllProductByName(String name);

    List<Product> getAllProductByCategory(String category);


    List<Product> getAllProductByBrand(String brand);

    List<Product> getAllProductBySellerEmail(String sellerEmail);

}
