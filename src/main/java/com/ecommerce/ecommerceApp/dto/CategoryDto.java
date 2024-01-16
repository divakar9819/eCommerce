package com.ecommerce.ecommerceApp.dto;

import com.ecommerce.ecommerceApp.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 08/01/2024 - 6:36 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoryDto implements Serializable {
    private int id;
    private String categoryName;
    @JsonIgnoreProperties("category")
    private List<ProductDto> productDtos;
}
