package com.ecommerce.ecommerceApp.repository;

import com.ecommerce.ecommerceApp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Divakar Verma
 * @created_at : 10/01/2024 - 6:28 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
