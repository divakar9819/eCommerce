package com.ecommerce.ecommerceApp.service;

import com.ecommerce.ecommerceApp.helper.response.ApiResponse;
import com.ecommerce.ecommerceApp.payload.request.ProductRequest;
import com.ecommerce.ecommerceApp.payload.response.ProductResponse;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 07/01/2024 - 11:40 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public interface ProductService {

    public ProductResponse createProduct(ProductRequest productRequest);
    public ProductResponse getProductById(int id);
    public ProductResponse updateProduct(int id, ProductRequest product);
    public ApiResponse deleteProduct(int id);
    public List<ProductResponse> getAllProduct();

    public List<ProductResponse> searchProductByCategory(String categoryName);

}
