package com.ecommerce.ecommerceApp.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 17/01/2024 - 1:15 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CategoryRequest {

    private String categoryName;
    @JsonIgnoreProperties("categoryRequest")
    private List<ProductRequest> productRequests;
}
