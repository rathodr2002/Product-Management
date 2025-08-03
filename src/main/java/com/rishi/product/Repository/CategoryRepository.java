package com.rishi.product.Repository;

import com.rishi.product.DTO.CategoryDTO;
import com.rishi.product.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByName(String categoryName);
}
