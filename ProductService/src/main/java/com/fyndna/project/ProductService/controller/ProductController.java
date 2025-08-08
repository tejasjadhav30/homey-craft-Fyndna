package com.fyndna.project.ProductService.controller;


import com.fyndna.project.ProductService.model.Product;
import com.fyndna.project.ProductService.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {

    private final ProductServiceImpl productServiceImpl;
    private RestTemplate restTemplate;

    @GetMapping("/name/{name}")
    public List<Product> getAllProductsByName(@PathVariable String name){
        return productServiceImpl.getAllProductByName(name);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProducts(@RequestBody Product product){
        try{
            return new ResponseEntity<>(productServiceImpl.addProduct(product), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productServiceImpl.getProductById(id);
    }

    @GetMapping("/brand/{brand}")
    public List<Product> getProductByBrandName(@PathVariable String brand){
        return productServiceImpl.getAllProductByBrand(brand);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        try {
            return ResponseEntity.ok(productServiceImpl.updateProduct(id, product));
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id, @RequestParam String sellerEmailId) {
        try {
            productServiceImpl.deleteProduct(id);
            return ResponseEntity.ok("Product deleted");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }


}
