package com.ecommerce.ecommerceApp.service;

import com.ecommerce.ecommerceApp.entity.Cart;
import com.ecommerce.ecommerceApp.entity.CartItem;
import com.ecommerce.ecommerceApp.payload.response.CartResponse;

/**
 * @author Divakar Verma
 * @created_at : 18/01/2024 - 10:40 am
 * @mail_to: vermadivakar2022@gmail.com
 */
public interface CartService {

    public CartResponse getCartByUsername();
    public Cart addItemToCart(CartItem cartItem);
}
