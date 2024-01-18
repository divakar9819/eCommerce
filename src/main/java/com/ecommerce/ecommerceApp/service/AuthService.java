package com.ecommerce.ecommerceApp.service;

import com.ecommerce.ecommerceApp.payload.request.UserLoginRequest;
import com.ecommerce.ecommerceApp.payload.request.UserRegisterRequest;
import com.ecommerce.ecommerceApp.payload.response.UserRegisterResponse;
import com.ecommerce.ecommerceApp.utils.security.AccessToken;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 10/01/2024 - 6:29 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public interface AuthService {
    public UserRegisterResponse userRegistration(UserRegisterRequest userRegisterRequest);
    public AccessToken userLogin(UserLoginRequest userLoginRequest);

    public List<UserRegisterResponse> getAllUser();

}
