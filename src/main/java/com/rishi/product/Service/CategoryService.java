package com.rishi.product.Service;

import com.rishi.product.DTO.CategoryDTO;
import com.rishi.product.Entity.Category;
import com.rishi.product.Exception.CategoryAlreadyExistsException;
import com.rishi.product.Mapper.CategoryMapper;
import com.rishi.product.Repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;
    //public CategoryService(CategoryRepository categoryRepository)
    //{
    //    this.categoryRepository = categoryRepository;
    //}

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty())
        {
            System.out.println("No Categories found in the database.");
        }
        return categories.stream().map(CategoryMapper::toCategoryDTO).collect(Collectors.toList());
    }

    //converting categoryDTO entity with help og Mapper and save ind db
    public CategoryDTO createCategory(CategoryDTO categoryDTO)
    {
        Optional<Category> existsCategory = categoryRepository.findByName(categoryDTO.getName());
        if(existsCategory.isPresent())
        {
            throw new CategoryAlreadyExistsException("Category " + categoryDTO.getName() + " already exists with same Name");
        }
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    public String deleteCategoryById(long categoryId)
    {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent())
        {
            Category category = optionalCategory.get();
            String categoryName = category.getName();

            categoryRepository.deleteById(categoryId);
            return "Deleted Category of Id : " +categoryId+ " with Name : "+categoryName;
        }else{
            return "Category with Id : " + categoryId + " not found.";
        }
    }

    //update category
    public CategoryDTO updateCategory(CategoryDTO categoryDTO)
    {
        if(categoryDTO.getId() == null)
        {
            throw new IllegalArgumentException("Product Id cannot be Null");
        }
        Optional<Category> optionalCategory = categoryRepository.findById(categoryDTO.getId());
        if(optionalCategory.isPresent())
        {
            Category category = optionalCategory.get();

            category.setName(categoryDTO.getName());
            Category updatedCategory = categoryRepository.save(category);

            return CategoryMapper.toCategoryDTO(updatedCategory);
        }else{
            throw new EntityNotFoundException("Category not Found with ID : "+categoryDTO.getId());
        }
    }


    public CategoryDTO getCategoryById(long id)
    {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent())
        {
            Category category = optionalCategory.get();
            return CategoryMapper.toCategoryDTO(category);
        }else{
            throw new EntityNotFoundException("Category not Found with ID "+id);
        }
    }
}
