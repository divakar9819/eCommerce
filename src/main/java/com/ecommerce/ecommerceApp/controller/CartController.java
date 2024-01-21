package com.ecommerce.ecommerceApp.controller;

import com.ecommerce.ecommerceApp.entity.Cart;
import com.ecommerce.ecommerceApp.entity.CartItem;
import com.ecommerce.ecommerceApp.payload.request.CartItemRequest;
import com.ecommerce.ecommerceApp.payload.response.CartItemResponse;
import com.ecommerce.ecommerceApp.payload.response.CartResponse;
import com.ecommerce.ecommerceApp.service.CartItemService;
import com.ecommerce.ecommerceApp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Divakar Verma
 * @created_at : 18/01/2024 - 12:03 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@RestController
@RequestMapping("api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;
    @GetMapping("/home")
    public String home(){
        return "cart home";
    }

    @GetMapping("/getUserCart")
    public ResponseEntity<CartResponse> getCartByUsername(){
        CartResponse cartResponse = cartService.getCartByUsername();
        return new ResponseEntity<>(cartResponse, HttpStatus.CREATED);
    }

    @PostMapping("/addItemToCart")
    public ResponseEntity<CartItemResponse> addItemToCart(@RequestBody CartItemRequest cartItemRequest){
        CartItemResponse cartItemResponse = cartItemService.addCartItem(cartItemRequest);
        return new ResponseEntity<>(cartItemResponse,HttpStatus.CREATED);
    }
}
