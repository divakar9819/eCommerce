package com.ecommerce.ecommerceApp.serviceImpl;

import com.ecommerce.ecommerceApp.entity.Category;
import com.ecommerce.ecommerceApp.entity.Product;
import com.ecommerce.ecommerceApp.exception.ResourceNotFoundException;
import com.ecommerce.ecommerceApp.helper.ApiResponse;
import com.ecommerce.ecommerceApp.payload.request.CategoryRequest;
import com.ecommerce.ecommerceApp.payload.request.ProductRequest;
import com.ecommerce.ecommerceApp.payload.response.CategoryResponse;
import com.ecommerce.ecommerceApp.payload.response.ProductResponse;
import com.ecommerce.ecommerceApp.repository.ProductRepository;
import com.ecommerce.ecommerceApp.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = productRequestToProduct(productRequest);
        Product createdProduct = productRepository.save(product);
        return productToProductResponse(createdProduct);
    }

    @Override
    public ProductResponse getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","productId",String.valueOf(id)));
        ProductResponse productResponse = productToProductResponse(product);
        return productResponse;
    }

    @Override
    public ProductResponse updateProduct(int id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","productId",String.valueOf(id)));
        if(productRequest.getProductName()!=null){
            product.setProductName(productRequest.getProductName());
        }
        if(productRequest.getPrice()!=0.0){
            product.setPrice(productRequest.getPrice());
        }
        if(productRequest.getDiscount()!=0){

        }
        return null;
    }

    @Override
    public ApiResponse deleteProduct(int id) {
        return null;
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = products.stream().map(this::productToProductResponse).toList();
        return productResponses;
    }

    @Override
    public List<ProductResponse> searchProductByCategory(String categoryName) {
        List<Product> products = productRepository.findByCategory_CategoryName(categoryName);
        if(products.isEmpty()){
            throw new ResourceNotFoundException("Product","categoryName",categoryName);
        }
        else {

            List<ProductResponse> productResponses = products.stream().map(this::productToProductResponse).toList();
            return productResponses;
        }
    }


    public Product productRequestToProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setPrice(productRequest.getPrice());
        product.setDiscount(productRequest.getDiscount());
        product.setDescription(productRequest.getDescription());
        product.setCategory(categoryRequestToCategory(productRequest.getCategoryRequest()));
        return product;
    }

    public Category categoryRequestToCategory(CategoryRequest categoryRequest){
        return this.modelMapper.map(categoryRequest,Category.class);
    }

    public ProductResponse productToProductResponse(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setProductName(product.getProductName());
        productResponse.setPrice(product.getPrice());
        productResponse.setDiscount(product.getDiscount());
        productResponse.setDescription(product.getDescription());
        Category category = product.getCategory();
        productResponse.setCategoryResponse(categoryToCategoryResponse(category));
        return productResponse;
    }

//    public CategoryDto categoryToCategoryDto(Category category){
//        return this.modelMapper.map(category,CategoryDto.class);
//    }

    public CategoryResponse categoryToCategoryResponse(Category category){
        return this.modelMapper.map(category,CategoryResponse.class);
    }


}
