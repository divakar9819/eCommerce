package com.ecommerce.ecommerceApp.serviceImpl;

import com.ecommerce.ecommerceApp.dto.CategoryDto;
import com.ecommerce.ecommerceApp.dto.ProductDto;
import com.ecommerce.ecommerceApp.entity.Category;
import com.ecommerce.ecommerceApp.entity.Product;
import com.ecommerce.ecommerceApp.exception.ResourceNotFoundException;
import com.ecommerce.ecommerceApp.helper.response.ApiResponse;
import com.ecommerce.ecommerceApp.repository.ProductRepository;
import com.ecommerce.ecommerceApp.service.ProductService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Divakar Verma
 * @created_at : 07/01/2024 - 11:41 pm
 * @mail_to: vermadivakar2022@gmail.com
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ProductDto createProduct(Product product) {
        Product createdProduct = productRepository.save(product);
        return productToProductDto(createdProduct);
    }

    @Override
    public ProductDto getProductById(int id) {
        return null;
    }

    @Override
    public ProductDto updateProduct(int id, Product product) {
        return null;
    }

    @Override
    public ApiResponse deleteProduct(int id) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepository.findAll();
        System.out.println(products.get(0).getCategory().getCategoryName());
        List<ProductDto> productDtos = products.stream().map(this::productToProductDto).toList();
        return productDtos;
    }

    @Override
    public List<ProductDto> searchProductByCategory(String categoryName) {
        List<Product> products = productRepository.findByCategory_CategoryName(categoryName);
        if(products.isEmpty()){
            throw new ResourceNotFoundException("Product","categoryName",categoryName);
        }
        else {
            List<ProductDto> productDtos = products.stream().map(this::productToProductDto).toList();
            return productDtos;
        }
    }

    public ProductDto productToProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductName(product.getProductName());
        productDto.setPrice(product.getPrice());
        productDto.setDiscount(product.getDiscount());
        productDto.setDescription(product.getDescription());
        System.out.println(product.getCategory().getCategoryName());
        productDto.setCategoryDto(categoryToCategoryDto(product.getCategory()));
        return productDto;
    }

    public CategoryDto categoryToCategoryDto(Category category){
        return this.modelMapper.map(category,CategoryDto.class);
    }
}
