package com.ecommerce.ecommerceApp.service;

import com.ecommerce.ecommerceApp.dto.CategoryDto;
import com.ecommerce.ecommerceApp.entity.Category;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 08/01/2024 - 6:15 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public interface CategoryService {
    public CategoryDto createCategory(Category category);

    public List<CategoryDto> getAllCategory();
}
