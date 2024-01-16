package com.ecommerce.ecommerceApp.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Divakar Verma
 * @created_at : 10/01/2024 - 6:11 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Role extends BaseEntity{
    private String name;
}
