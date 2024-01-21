package com.ecommerce.ecommerceApp.helper;

import com.ecommerce.ecommerceApp.entity.Cart;
import com.ecommerce.ecommerceApp.entity.CartItem;
import com.ecommerce.ecommerceApp.entity.Category;
import com.ecommerce.ecommerceApp.entity.Product;
import com.ecommerce.ecommerceApp.payload.response.CartItemResponse;
import com.ecommerce.ecommerceApp.payload.response.CartResponse;
import com.ecommerce.ecommerceApp.payload.response.CategoryResponse;
import com.ecommerce.ecommerceApp.payload.response.ProductResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 19/01/2024 - 1:42 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public class Helper {

    @Autowired
    private ModelMapper modelMapper;

    public ProductResponse productToProductResponse(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setProductName(product.getProductName());
        productResponse.setPrice(product.getPrice());
        productResponse.setDiscount(product.getDiscount());
        productResponse.setDescription(product.getDescription());
        Category category = product.getCategory();
        productResponse.setCategoryResponse(categoryToCategoryResponse(category));
        return productResponse;
    }

    public CategoryResponse categoryToCategoryResponse(Category category){
        return this.modelMapper.map(category,CategoryResponse.class);
    }

    public CartResponse cartToCartResponse(Cart cart){
        CartResponse cartResponse = new CartResponse();
        cartResponse.setId(cart.getId());
        List<CartItem> cartItems = cart.getCartItems();
        List<CartItemResponse> cartItemResponses = cartItems.stream().map(this::cartItemToCartItemResponse).toList();
        cartResponse.setCartItemResponses(cartItemResponses);
        cartResponse.setTotalPrice(getTotalPrice(cartItemResponses));
        return cartResponse;
    }

    public double getTotalPrice(List<CartItemResponse> cartItemResponses){
        double totalPrice = 0.0;
        for(CartItemResponse cartItemResponse : cartItemResponses){
            totalPrice += cartItemResponse.getProductPrice();
        }

        return totalPrice;
    }

    public CartItemResponse cartItemToCartItemResponse(CartItem cartItem){
        CartItemResponse cartItemResponse = new CartItemResponse();
        cartItemResponse.setId(cartItem.getId());
        cartItemResponse.setQuantity(cartItem.getQuantity());
        cartItemResponse.setDiscount(cartItem.getDiscount());
        Product product = cartItem.getProduct();
        cartItemResponse.setProductResponse(productToProductResponse(product));
        double productPrice = cartItemResponse.getProductResponse().getPrice();
        double totalPrice = productPrice*cartItem.getQuantity() - cartItem.getDiscount();
        cartItemResponse.setProductPrice(totalPrice);
        return cartItemResponse;
    }
}
