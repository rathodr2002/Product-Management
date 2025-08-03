package com.rishi.product.Controller;

import com.rishi.product.DTO.CategoryDTO;
import com.rishi.product.DTO.ProductDTO;
import com.rishi.product.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class ProductController {

    private ProductService productService;

    @GetMapping("/getAllProducts")
    public List<ProductDTO> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping("/addProduct")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO)
    {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/deleteProductById/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        return productService.deleteProductById(id);
    }

    //update products
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/UpdateProductById")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO)
    {
        return new ResponseEntity<>(productService.updateProduct(productDTO),HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id)
    {
        ProductDTO productDTO = productService.getProductById(id);
        if (productDTO != null) {
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
