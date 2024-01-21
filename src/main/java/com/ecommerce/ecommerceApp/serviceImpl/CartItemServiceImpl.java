package com.ecommerce.ecommerceApp.serviceImpl;

import com.ecommerce.ecommerceApp.entity.Cart;
import com.ecommerce.ecommerceApp.entity.CartItem;
import com.ecommerce.ecommerceApp.entity.Product;
import com.ecommerce.ecommerceApp.exception.ResourceNotFoundException;
import com.ecommerce.ecommerceApp.helper.Helper;
import com.ecommerce.ecommerceApp.payload.request.CartItemRequest;
import com.ecommerce.ecommerceApp.payload.response.CartItemResponse;
import com.ecommerce.ecommerceApp.payload.response.ProductResponse;
import com.ecommerce.ecommerceApp.repository.CartItemRepository;
import com.ecommerce.ecommerceApp.repository.CartRepository;
import com.ecommerce.ecommerceApp.repository.ProductRepository;
import com.ecommerce.ecommerceApp.service.CartItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Divakar Verma
 * @created_at : 18/01/2024 - 4:16 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Helper helper;

    @Override
    public CartItemResponse addCartItem(CartItemRequest cartItemRequest) {

        Product product = productRepository.findById(cartItemRequest.getProductId()).orElseThrow(()-> new ResourceNotFoundException("Product","productId",String.valueOf(cartItemRequest.getProductId())));
        Cart cart = cartRepository.findById(cartItemRequest.getCardId()).orElseThrow(()-> new ResourceNotFoundException("Cart","cartId",String.valueOf(cartItemRequest.getCardId())));
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(cartItemRequest.getQuantity());
        cartItem.setDiscount(cartItemRequest.getDiscount());
        double productPrice = product.getPrice();
        double productDiscount = product.getDiscount() + cartItem.getDiscount();
        double productTotalPrice = cartItemRequest.getQuantity()*productPrice - productDiscount;
        //cartItem.setProductPrice(productTotalPrice);
        CartItem createdCartItem = cartItemRepository.save(cartItem);
        return helper.cartItemToCartItemResponse(createdCartItem);
    }

//    public CartItemResponse cartItemToCartItemResponse(CartItem cartItem){
//        CartItemResponse cartItemResponse = new CartItemResponse();
//        cartItemResponse.setId(cartItem.getId());
//        cartItemResponse.setQuantity(cartItem.getQuantity());
//        cartItemResponse.setDiscount(cartItem.getDiscount());
//        cartItemResponse.setProductPrice(cartItem.getProductPrice());
//        Product product = cartItem.getProduct();
//        cartItemResponse.setProductResponse(helper.productToProductResponse(product));
//        return cartItemResponse;
//    }
//
//    public ProductResponse productToProductResponse(Product product){
//        ProductResponse productResponse = new ProductResponse();
//        return this.modelMapper.map(product,ProductResponse.class);
//    }
}
