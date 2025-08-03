package com.rishi.product.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Data
@Entity
@Getter @Setter
//@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

    //Relation of Category with Product
    @ManyToOne(fetch = FetchType.LAZY)
    //EAGER : When Product is fetched Category is also loaded by default.
    // Category table is join with Product and fetch all categories.

    //LAZY : When Product is fetched Category is not loaded.
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;
}

// Controller calls -> service call -> repository calls
