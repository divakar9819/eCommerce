package com.ecommerce.ecommerceApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 07/01/2024 - 11:23 pm
 * @mail_to: vermadivakar2022@gmail.com
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category extends BaseEntity implements Serializable {
    private String categoryName;
    @OneToMany(mappedBy = "category",orphanRemoval = true,
            cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("category")
    private List<Product> products;
}
