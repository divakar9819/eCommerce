package com.ecommerce.ecommerceApp.payload.response;

import com.ecommerce.ecommerceApp.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Divakar Verma
 * @created_at : 19/01/2024 - 1:20 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItemResponse {

    private int id;
    private ProductResponse productResponse;
    private int quantity;
    private double discount;
    private  double productPrice;
}
