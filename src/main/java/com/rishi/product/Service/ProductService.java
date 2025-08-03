package com.rishi.product.Service;

import com.rishi.product.DTO.ProductDTO;
import com.rishi.product.Entity.Category;
import com.rishi.product.Entity.Product;
import com.rishi.product.Exception.CategoryNotFoundException;
import com.rishi.product.Mapper.ProductMapper;
import com.rishi.product.Repository.CategoryRepository;
import com.rishi.product.Repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public List<ProductDTO> getAllProducts ()
    {
        List<Product> productList = productRepository.findAll();
        if(productList.isEmpty()) {
            System.out.println("No products found in the database.");
        }
        return productList.stream().map(ProductMapper::toProductDTO).collect(Collectors.toList());
    }

    public ProductDTO createProduct(ProductDTO productDTO)
    {
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new CategoryNotFoundException("Category Not Found for Id :" + productDTO.getCategoryId()));
        Product product = ProductMapper.toProductEntity(productDTO,category);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    public ProductDTO updateProduct(ProductDTO productDTO)
    {
        if(productDTO.getId() == null)
        {
            throw new IllegalArgumentException("Product Id cannot be Null");
        }

        Optional<Product> optionalProduct = productRepository.findById(productDTO.getId());
        if(optionalProduct.isPresent())
        {
            System.out.println("Updated");
            Product product = optionalProduct.get();

            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());

            Product updatedProduct = productRepository.save(product);
            return ProductMapper.toProductDTO(updatedProduct);
        }else{
            throw new EntityNotFoundException("Product not Found with Id : "+ productDTO.getId());
        }
    }

    public String deleteProductById(long id)
    {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent())
        {
            Product product = optionalProduct.get();
            String productName = product.getName();
            productRepository.deleteById(id);
            return "Deleted Product of Id : " +id+ " with Name : "+productName;
        }else{
            return "Product with Id : " + id + " not found.";
        }
    }

    public ProductDTO getProductById(long id)
    {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent())
        {
            Product product = optionalProduct.get();
            return ProductMapper.toProductDTO(product);
        }else{
            throw new EntityNotFoundException("Product not Found with Id "+id);
        }
    }
}
