package com.ecommerce.ecommerceApp.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Divakar Verma
 * @created_at : 17/01/2024 - 1:14 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductRequest {
    private String productName;
    private double price;
    private double discount;
    private String description;
    private CategoryRequest categoryRequest;
}
