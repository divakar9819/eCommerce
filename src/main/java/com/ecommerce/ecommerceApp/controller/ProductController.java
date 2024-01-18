package com.ecommerce.ecommerceApp.controller;

import com.ecommerce.ecommerceApp.payload.request.ProductRequest;
import com.ecommerce.ecommerceApp.payload.response.ProductResponse;
import com.ecommerce.ecommerceApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 07/01/2024 - 11:44 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String home(){
        return "Product home";
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest){
        ProductResponse createdProduct = productService.createProduct(productRequest);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }


    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ProductResponse>> getAllProduct(){
        List<ProductResponse> productResponse = productService.getAllProduct();
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @GetMapping ("/searchProductByCategory/{categoryName}")
    public ResponseEntity<List<ProductResponse>> searchProductByCategory(@PathVariable String categoryName){
        List<ProductResponse> productResponses = productService.searchProductByCategory(categoryName);
        return new ResponseEntity<>(productResponses,HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Integer id){
        ProductResponse productResponses = productService.getProductById(id);
        return new ResponseEntity<>(productResponses,HttpStatus.OK);
    }


}
