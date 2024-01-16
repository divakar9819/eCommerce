package com.ecommerce.ecommerceApp.repository;

import com.ecommerce.ecommerceApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Divakar Verma
 * @created_at : 10/01/2024 - 6:27 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public Optional<User> findByUsername(String username);
}
