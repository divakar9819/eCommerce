package com.ecommerce.ecommerceApp.service;

import com.ecommerce.ecommerceApp.entity.CartItem;
import com.ecommerce.ecommerceApp.payload.request.CartItemRequest;
import com.ecommerce.ecommerceApp.payload.response.CartItemResponse;

/**
 * @author Divakar Verma
 * @created_at : 17/01/2024 - 5:56 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public interface CartItemService {

    public CartItemResponse addCartItem(CartItemRequest cartItemRequest);

}
