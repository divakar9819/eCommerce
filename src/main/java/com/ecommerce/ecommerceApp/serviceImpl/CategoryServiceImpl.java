package com.ecommerce.ecommerceApp.serviceImpl;

import com.ecommerce.ecommerceApp.dto.CategoryDto;
import com.ecommerce.ecommerceApp.dto.ProductDto;
import com.ecommerce.ecommerceApp.entity.Category;
import com.ecommerce.ecommerceApp.entity.Product;
import com.ecommerce.ecommerceApp.repository.CategoryRepository;
import com.ecommerce.ecommerceApp.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 08/01/2024 - 6:16 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(Category category) {
        for(Product product: category.getProducts()){
            product.setCategory(category);
        }
        Category createdCategory = categoryRepository.save(category);
        return categoryToCategoryDto(createdCategory);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(this::categoryToCategoryDto).toList();
        return categoryDtos;
    }

    public CategoryDto categoryToCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setCategoryName(category.getCategoryName());
        List<Product> products = category.getProducts();
        List<ProductDto> productDtos = products.stream().map(this::productToProductDto).toList();
        categoryDto.setProductDtos(productDtos);
        return  categoryDto;
    }

    public ProductDto productToProductDto(Product product){
        return this.modelMapper.map(product,ProductDto.class);
    }
}
