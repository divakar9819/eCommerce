package com.ecommerce.ecommerceApp.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

/**
 * @author Divakar Verma
 * @created_at : 07/01/2024 - 11:20 pm
 * @mail_to: vermadivakar2022@gmail.com
 */

@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
