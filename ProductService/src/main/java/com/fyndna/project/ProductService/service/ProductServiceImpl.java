package com.fyndna.project.ProductService.service;


import com.fyndna.project.ProductService.model.Product;
import com.fyndna.project.ProductService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;


//    @Override
//    public Integer getQuantity(String productId) {
//        return productRepository.getQuantity(productId);
//    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public boolean deleteProduct(Long productId) {

       try{
           Optional<Product> existingId= getProductById(productId);
           if(existingId.isPresent()){
               productRepository.deleteById(productId);
           }
       }catch (Exception e){
           return false;
       }
        return true;
    }

    @Override
    public Product updateProduct(Long id, Product product) {

        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        Optional<Product> existingProductOpt = getProductById(id);
        if (existingProductOpt.isEmpty()) {
            throw new RuntimeException("Product with ID " + id + " not found");
        }

        Product existingProduct = existingProductOpt.get();

            if (!existingProduct.getSellerEmail().equals(product.getSellerEmail())) {
            throw new RuntimeException("Unauthorized update attempt");
        }

        // Update only the fields that are allowed
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setBrand(product.getBrand());
        existingProduct.setQuantity(product.getQuantity());

        return productRepository.save(existingProduct);
    }


    @Override
    public List<Product> getAllProductByName(String name) {
        return productRepository.getAllProductByName(name);
    }

    @Override
    public List<Product> getAllProductByCategory(String category) {
        return productRepository.getAllProductByCategory(category);
    }

    @Override
    public List<Product> getAllProductByBrand(String brand) {
        return productRepository.getAllProductByBrand(brand);
    }

    @Override
    public List<Product> getAllProductBySellerEmail(String sellerEmail) {
        return productRepository.findProductsBySellerEmail(sellerEmail);
    }
}
