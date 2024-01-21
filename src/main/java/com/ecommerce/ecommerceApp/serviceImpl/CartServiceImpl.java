package com.ecommerce.ecommerceApp.serviceImpl;

import com.ecommerce.ecommerceApp.entity.Cart;
import com.ecommerce.ecommerceApp.entity.CartItem;
import com.ecommerce.ecommerceApp.exception.ResourceNotFoundException;
import com.ecommerce.ecommerceApp.exception.UserNotFoundException;
import com.ecommerce.ecommerceApp.helper.Helper;
import com.ecommerce.ecommerceApp.payload.response.CartResponse;
import com.ecommerce.ecommerceApp.repository.CartRepository;
import com.ecommerce.ecommerceApp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ecommerce.ecommerceApp.utils.security.jwt.JwtTokenProvider.getUsername;

/**
 * @author Divakar Verma
 * @created_at : 18/01/2024 - 10:44 am
 * @mail_to: vermadivakar2022@gmail.com
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private Helper helper;
    @Override
    public CartResponse getCartByUsername() {
        String username = getUsername();
        Cart cart = cartRepository.findByUser_Username(username);
        if(cart==null){
            throw new UserNotFoundException("User data is not exits");
        }
        return helper.cartToCartResponse(cart);
    }

    @Override
    public Cart addItemToCart(CartItem cartItem) {
        return null;
    }
}
