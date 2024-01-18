package com.ecommerce.ecommerceApp.payload.request;

import com.ecommerce.ecommerceApp.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
public class UserRegisterRequest {
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<RoleRequest> rolesRequest = new HashSet<>();
    private List<AddressRequest> addressRequests = new ArrayList<>();
}
