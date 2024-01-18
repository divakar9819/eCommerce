package com.ecommerce.ecommerceApp.repository;

import com.ecommerce.ecommerceApp.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Divakar Verma
 * @created_at : 17/01/2024 - 5:33 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
}
