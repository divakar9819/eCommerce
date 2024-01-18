package com.ecommerce.ecommerceApp.controller;

import com.ecommerce.ecommerceApp.payload.request.UserLoginRequest;
import com.ecommerce.ecommerceApp.payload.request.UserRegisterRequest;
import com.ecommerce.ecommerceApp.payload.response.UserRegisterResponse;
import com.ecommerce.ecommerceApp.service.AuthService;
import com.ecommerce.ecommerceApp.utils.security.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Divakar Verma
 * @created_at : 11/01/2024 - 10:51 am
 * @mail_to: vermadivakar2022@gmail.com
 */

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService userService;

    @GetMapping("/home")
    public String home(){
        return "user home";
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> createUser(@RequestBody UserRegisterRequest userRegisterDto){
        UserRegisterResponse createdUser = userService.userRegistration(userRegisterDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AccessToken> login(@RequestBody UserLoginRequest userLoginDto){
        AccessToken accessToken = userService.userLogin(userLoginDto);
        return new ResponseEntity<>(accessToken,HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserRegisterResponse>> getAllUser(){
        List<UserRegisterResponse> userRegisterResponses = userService.getAllUser();
        return new ResponseEntity<>(userRegisterResponses,HttpStatus.OK);
    }
}
