package com.ecommerce.ecommerceApp.service;

import com.ecommerce.ecommerceApp.dto.UserLoginDto;
import com.ecommerce.ecommerceApp.dto.UserRegisterDto;
import com.ecommerce.ecommerceApp.utils.security.AccessToken;

/**
 * @author Divakar Verma
 * @created_at : 10/01/2024 - 6:29 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
public interface AuthService {
    public UserRegisterDto userRegistration(UserRegisterDto userRegisterDto);
    public AccessToken userLogin(UserLoginDto userLoginDto);

}
