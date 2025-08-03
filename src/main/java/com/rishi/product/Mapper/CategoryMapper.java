package com.rishi.product.Mapper;

import com.rishi.product.DTO.CategoryDTO;
import com.rishi.product.Entity.Category;

public class CategoryMapper {

    public static Category toCategoryEntity(CategoryDTO categoryDTO)
    {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;
    }

    public static CategoryDTO toCategoryDTO(Category category)
    {
        if(category == null)
        {
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getCategoryId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProduct(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());
        return categoryDTO;
    }
}
