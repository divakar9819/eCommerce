package com.ecommerce.ecommerceApp.controller;

import com.ecommerce.ecommerceApp.dto.CategoryDto;
import com.ecommerce.ecommerceApp.dto.ProductDto;
import com.ecommerce.ecommerceApp.entity.Category;
import com.ecommerce.ecommerceApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<CategoryDto> createCategory(@RequestBody Category category){
        CategoryDto createdCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/getAllCategoryWithProduct")
    public ResponseEntity<List<CategoryDto>> getAllCategoryWithProduct(){
        List<CategoryDto> categoryDtos = categoryService.getAllCategory();
        return new ResponseEntity<>(categoryDtos,HttpStatus.OK);
    }

}
