package com.fyndna.project.ProductService.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


@Entity
@Table(name = "Products_Table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "Product_Name")
    @NotBlank
    private String name;

    @Column(name = "Product_Price")
    @NotNull
    private Double price;

    @Column(name = "Description")
    @NotBlank
    private String description;

    @Column(name = "Category")
    @NotBlank
    private String category;

    @Column(name = "Brand")
    @NotNull
    private String brand;

    @Column(name = "Seller_Email")
    @NotBlank
    private String sellerEmail;

    @Column(name = "Quantity")
    @NotNull
    private Integer quantity;


}
