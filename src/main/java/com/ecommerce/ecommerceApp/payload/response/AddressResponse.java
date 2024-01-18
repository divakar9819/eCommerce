package com.ecommerce.ecommerceApp.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Divakar Verma
 * @created_at : 17/01/2024 - 12:05 pm
 * @mail_to: vermadivakar2022@gmail.com
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AddressResponse {
    private int id;
    private String street;
    private String city;
    private String pinCode;
    private String state;
}
