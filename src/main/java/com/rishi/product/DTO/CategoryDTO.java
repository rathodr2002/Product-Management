package com.rishi.product.DTO;

import lombok.*;

import java.util.List;

//@Getter
//@Setter
@Data  //includes Getter and Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;
    private List<ProductDTO> product;

}
