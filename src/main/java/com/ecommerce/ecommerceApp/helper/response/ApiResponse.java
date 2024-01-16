package com.ecommerce.ecommerceApp.helper.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Divakar Verma
 * @created_at : 09/01/2024 - 12:29 am
 * @mail_to: vermadivakar2022@gmail.com
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponse {

    private String message;
    private boolean success;
}
