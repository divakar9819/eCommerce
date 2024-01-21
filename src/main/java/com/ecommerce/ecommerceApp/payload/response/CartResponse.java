package com.ecommerce.ecommerceApp.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 19/01/2024 - 2:47 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartResponse {
    private int id;
    private List<CartItemResponse> cartItemResponses;
    private double totalPrice;
}
