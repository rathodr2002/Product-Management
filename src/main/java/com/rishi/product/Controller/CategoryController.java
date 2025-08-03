package com.rishi.product.Controller;

import com.rishi.product.DTO.CategoryDTO;
import com.rishi.product.Exception.CategoryAlreadyExistsException;
import com.rishi.product.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("/getCategories")
    public List<CategoryDTO> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @GetMapping("/checkstatus")
    public String checkStatus()
    {
        return "Hello, Welcome to Product Management for Categories Department";
    }

    //Handling the exception if category is already exists.
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/addCategory")
    public ResponseEntity<?> categoryCategory(@RequestBody CategoryDTO categoryDTO){
        // Handling the Exception using GlobalException
//        try{
//            CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
//        }catch (CategoryAlreadyExistsException e){
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//        }
        //return new ResponseEntity<>(categoryService.createCategory(categoryDTO),HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryDTO));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/deleteCategoryById/{id}")
    public String deleteCategoryById(@PathVariable int id)
    {
        return categoryService.deleteCategoryById(id);
    }

    //update category
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/updateCategoryNameById")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO)
    {
        return new ResponseEntity<>(categoryService.updateCategory(categoryDTO),HttpStatus.OK);
    }

    @GetMapping("/getCategoryById/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable int id)
    {
        CategoryDTO category = categoryService.getCategoryById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
