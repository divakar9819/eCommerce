package com.ecommerce.ecommerceApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 17/01/2024 - 4:56 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cart extends BaseEntity{

    @OneToOne
    @JoinColumn(name="user_id")
    @JsonIgnoreProperties("cart")
    private User user;

    @JsonIgnoreProperties("cart")
    @OneToMany(mappedBy = "cart",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<CartItem> cartItems = new ArrayList<>();
    private double totalPrice = 0.0;
}
