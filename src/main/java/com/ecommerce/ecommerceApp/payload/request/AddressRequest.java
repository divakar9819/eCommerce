package com.ecommerce.ecommerceApp.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 17/01/2024 - 10:48 am
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressRequest {
    private String street;
    private String city;
    private String pinCode;
    private String state;
    private List<UserRegisterRequest> users = new ArrayList<>();
}
