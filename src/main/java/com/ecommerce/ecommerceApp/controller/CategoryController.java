package com.ecommerce.ecommerceApp.controller;


import com.ecommerce.ecommerceApp.entity.Category;
import com.ecommerce.ecommerceApp.payload.request.CategoryRequest;
import com.ecommerce.ecommerceApp.payload.response.CategoryResponse;
import com.ecommerce.ecommerceApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 08/01/2024 - 6:17 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home")
    public String home(){
        return "category home";
    }

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest){
        CategoryResponse createdCategory = categoryService.createCategory(categoryRequest);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/getAllCategoryWithProduct")
    public ResponseEntity<List<CategoryResponse>> getAllCategoryWithProduct(){
        List<CategoryResponse> categoryResponses = categoryService.getAllCategory();
        return new ResponseEntity<>(categoryResponses,HttpStatus.OK);
    }

    @GetMapping("/getCategoryById/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Integer id){
        CategoryResponse categoryResponse = categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryResponse,HttpStatus.OK);
    }

}
