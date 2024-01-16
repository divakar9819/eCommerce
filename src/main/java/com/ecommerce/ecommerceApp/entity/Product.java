package com.ecommerce.ecommerceApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * @author Divakar Verma
 * @created_at : 07/01/2024 - 11:23 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product extends BaseEntity implements Serializable {
    private String productName;
    private double price;
    private double discount;
    private String description;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("products")
    private Category category;



}
