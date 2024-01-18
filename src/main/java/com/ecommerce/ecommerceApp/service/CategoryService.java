package com.ecommerce.ecommerceApp.service;
import com.ecommerce.ecommerceApp.payload.request.CategoryRequest;
import com.ecommerce.ecommerceApp.payload.response.CategoryResponse;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 08/01/2024 - 6:15 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public interface CategoryService {
    public CategoryResponse createCategory(CategoryRequest categoryRequest);

    public List<CategoryResponse> getAllCategory();
    public CategoryResponse getCategoryById(int id);
}
