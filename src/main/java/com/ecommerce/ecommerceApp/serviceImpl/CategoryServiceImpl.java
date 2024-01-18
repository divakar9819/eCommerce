package com.ecommerce.ecommerceApp.serviceImpl;

import com.ecommerce.ecommerceApp.entity.Category;
import com.ecommerce.ecommerceApp.entity.Product;
import com.ecommerce.ecommerceApp.exception.ResourceNotFoundException;
import com.ecommerce.ecommerceApp.payload.request.CategoryRequest;
import com.ecommerce.ecommerceApp.payload.request.ProductRequest;
import com.ecommerce.ecommerceApp.payload.response.CategoryResponse;
import com.ecommerce.ecommerceApp.payload.response.ProductResponse;
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
    public CategoryResponse createCategory(CategoryRequest categoryRequest) {
        Category category = categoryRequestToCategory(categoryRequest);
        for(Product product: category.getProducts()){
            product.setCategory(category);
        }
        Category createdCategory = categoryRepository.save(category);
        return categoryToCategoryResponse(createdCategory);
    }

    @Override
    public List<CategoryResponse> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = categories.stream().map(this::categoryToCategoryResponse).toList();
        return categoryResponses;
    }

    @Override
    public CategoryResponse getCategoryById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",String.valueOf(id)));
        return categoryToCategoryResponse(category);
    }

    public CategoryResponse categoryToCategoryResponse(Category category){
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setCategoryName(category.getCategoryName());
        List<Product> products = category.getProducts();
        List<ProductResponse> productResponses = products.stream().map(this::productToProductResponse).toList();
        categoryResponse.setProductResponses(productResponses);
        return categoryResponse;
    }
    public ProductResponse productToProductResponse(Product product){
        return this.modelMapper.map(product,ProductResponse.class);
    }

    public Category categoryRequestToCategory(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setCategoryName(categoryRequest.getCategoryName());
        List<ProductRequest> productRequests = categoryRequest.getProductRequests();
        List<Product> products = productRequests.stream().map(this::productRequestToProduct).toList();
        category.setProducts(products);
        return category;
    }

    public Product productRequestToProduct(ProductRequest productRequest){
        return this.modelMapper.map(productRequest,Product.class);
    }
}
