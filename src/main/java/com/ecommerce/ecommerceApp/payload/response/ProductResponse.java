package com.ecommerce.ecommerceApp.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * @author Divakar Verma
 * @created_at : 17/01/2024 - 12:49 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class ProductResponse {
    private int id;
    private String productName;
    private double price;
    private double discount;
    private String description;
    @JsonIgnoreProperties("productResponses")
    private CategoryResponse categoryResponse;
}
