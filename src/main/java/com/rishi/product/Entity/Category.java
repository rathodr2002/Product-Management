package com.rishi.product.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;
    private String name;

    //Mapping it with category object (taking reference name of Category)
    // If Category is deleted then all product under that will delete
    //Relation of Product and Category is One to Many
    //EAGER : When Category is fetched product is also loaded by default.
    // product table is join with Category and fetch all products.
    //LAZY : When Category is fetched product is not loaded.
    @OneToMany(mappedBy = "category" , fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();
}
