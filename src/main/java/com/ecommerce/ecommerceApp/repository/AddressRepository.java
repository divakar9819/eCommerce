package com.ecommerce.ecommerceApp.repository;

import com.ecommerce.ecommerceApp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Divakar Verma
 * @created_at : 17/01/2024 - 10:44 am
 * @mail_to: vermadivakar2022@gmail.com
 */
@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
