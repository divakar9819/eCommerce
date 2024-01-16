package com.ecommerce.ecommerceApp.controller;

import com.ecommerce.ecommerceApp.dto.UserLoginDto;
import com.ecommerce.ecommerceApp.dto.UserRegisterDto;
import com.ecommerce.ecommerceApp.service.AuthService;
import com.ecommerce.ecommerceApp.utils.security.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.AcceptPendingException;

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
    public ResponseEntity<UserRegisterDto> createUser(@RequestBody UserRegisterDto userRegisterDto){
        UserRegisterDto createdUser = userService.userRegistration(userRegisterDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AccessToken> login(@RequestBody UserLoginDto userLoginDto){
        AccessToken accessToken = userService.userLogin(userLoginDto);
        return new ResponseEntity<>(accessToken,HttpStatus.OK);
    }
}
