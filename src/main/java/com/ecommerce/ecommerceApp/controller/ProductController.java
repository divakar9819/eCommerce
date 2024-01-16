package com.ecommerce.ecommerceApp.controller;

import com.ecommerce.ecommerceApp.dto.ProductDto;
import com.ecommerce.ecommerceApp.entity.Product;
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
    public ResponseEntity<ProductDto> createProduct(@RequestBody Product product){
        ProductDto createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }


    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        List<ProductDto> productDtos = productService.getAllProduct();
        return new ResponseEntity<>(productDtos,HttpStatus.OK);
    }

    @GetMapping ("/searchProductByCategory/{categoryName}")
    public ResponseEntity<List<ProductDto>> searchProductByCategory(@PathVariable String categoryName){
        List<ProductDto> productDtos = productService.searchProductByCategory(categoryName);
        return new ResponseEntity<>(productDtos,HttpStatus.OK);
    }


}
