package com.ecommerce.ecommerceApp.dto;

import com.ecommerce.ecommerceApp.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Divakar Verma
 * @created_at : 10/01/2024 - 6:33 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserRegisterDto {
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();
}
