package com.ecommerce.ecommerceApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 17/01/2024 - 10:37 am
 * @mail_to: vermadivakar2022@gmail.com
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address extends BaseEntity{
    private String street;
    private String city;
    private String pinCode;
    private String state;
    @ManyToMany(mappedBy = "addresses", fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();
}
