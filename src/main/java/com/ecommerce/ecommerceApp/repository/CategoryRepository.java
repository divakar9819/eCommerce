package com.ecommerce.ecommerceApp.repository;

import com.ecommerce.ecommerceApp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Divakar Verma
 * @created_at : 07/01/2024 - 11:37 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
