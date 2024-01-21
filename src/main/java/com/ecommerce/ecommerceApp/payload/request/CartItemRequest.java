package com.ecommerce.ecommerceApp.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Divakar Verma
 * @created_at : 17/01/2024 - 5:57 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItemRequest {
    private int cardId;
    private int productId;
    private int quantity;
    //private double productPrice;
    private double discount;
}
