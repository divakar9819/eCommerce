package com.ecommerce.ecommerceApp.serviceImpl;

import com.ecommerce.ecommerceApp.dto.UserLoginDto;
import com.ecommerce.ecommerceApp.dto.UserRegisterDto;
import com.ecommerce.ecommerceApp.entity.Role;
import com.ecommerce.ecommerceApp.entity.User;
import com.ecommerce.ecommerceApp.exception.security.CustomSecurityException;
import com.ecommerce.ecommerceApp.repository.UserRepository;
import com.ecommerce.ecommerceApp.service.AuthService;
import com.ecommerce.ecommerceApp.utils.constant.ApiMessage;
import com.ecommerce.ecommerceApp.utils.security.AccessToken;
import com.ecommerce.ecommerceApp.utils.security.ITokenProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Divakar Verma
 * @created_at : 10/01/2024 - 6:38 pm
 * @mail_to: vermadivakar2022@gmail.com
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ITokenProvider tokenProvider;
    @Override
    public UserRegisterDto userRegistration(UserRegisterDto userRegisterDto) {
        userRegisterDto.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        User createdUser = userRepository.save(userDtoTouser(userRegisterDto));
        return userToUserDto(createdUser);
    }

    @Override
    public AccessToken userLogin(UserLoginDto userLoginDto) {
        String username = userLoginDto.getUsername();
        String password = userLoginDto.getPassword();
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            Set<Role> roles = userRepository.findByUsername(username).get().getRoles();
            return tokenProvider.createToken(username,roles);

        }catch (AuthenticationException exception) {
            throw new CustomSecurityException(ApiMessage.BAD_CREDENTIALS, HttpStatus.BAD_REQUEST);

        }
    }

    public User userDtoTouser(UserRegisterDto userRegisterDto){
        return this.modelMapper.map(userRegisterDto,User.class);
    }

    public UserRegisterDto userToUserDto(User user){
        return this.modelMapper.map(user,UserRegisterDto.class);
    }
}
