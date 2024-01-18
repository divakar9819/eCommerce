package com.ecommerce.ecommerceApp.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 17/01/2024 - 12:49 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoryResponse {
    private int id;
    private String categoryName;
    @JsonIgnoreProperties("categoryResponse")
    private List<ProductResponse> productResponses;
}
