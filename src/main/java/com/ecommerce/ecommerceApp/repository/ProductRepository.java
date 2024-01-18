package com.ecommerce.ecommerceApp.repository;


import com.ecommerce.ecommerceApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 07/01/2024 - 11:37 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

//    @Query(value = "SELECT new com.ecommerce.ecommerceApp.dto.ProductDto(p.name, c.id, c.categoryName) FROM Product p INNER JOIN Category c ON p.category_id = c.id")
//    public List<ProductDto> findAllProductWithCategory();

    public List<Product> findByCategory_CategoryName(String categoryName);
}
