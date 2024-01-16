package com.ecommerce.ecommerceApp.service;

import com.ecommerce.ecommerceApp.dto.ProductDto;
import com.ecommerce.ecommerceApp.entity.Product;
import com.ecommerce.ecommerceApp.helper.response.ApiResponse;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 07/01/2024 - 11:40 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public interface ProductService {

    public ProductDto createProduct(Product product);
    //public List<Product> getAllProduct();
    public ProductDto getProductById(int id);
    public ProductDto updateProduct(int id, Product product);
    public ApiResponse deleteProduct(int id);
    public List<ProductDto> getAllProduct();

    public List<ProductDto> searchProductByCategory(String categoryName);

}
