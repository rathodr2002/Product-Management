package com.rishi.product.Mapper;

import com.rishi.product.DTO.ProductDTO;
import com.rishi.product.Entity.Category;
import com.rishi.product.Entity.Product;

public class ProductMapper {

    //entity to productdto
    public static ProductDTO toProductDTO(Product product)
    {
        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getCategory().getCategoryId()
        );
    }
    //productdto to entity
    public static Product toProductEntity(ProductDTO productDTO, Category category)
    {
        Product product = new Product();
        //product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;
    }
}
