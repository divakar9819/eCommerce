package com.ecommerce.ecommerceApp.serviceImpl;

import com.ecommerce.ecommerceApp.entity.Cart;
import com.ecommerce.ecommerceApp.payload.request.AddressRequest;
import com.ecommerce.ecommerceApp.payload.request.UserLoginRequest;
import com.ecommerce.ecommerceApp.payload.request.UserRegisterRequest;
import com.ecommerce.ecommerceApp.entity.Address;
import com.ecommerce.ecommerceApp.entity.Role;
import com.ecommerce.ecommerceApp.entity.User;
import com.ecommerce.ecommerceApp.exception.UserNotFoundException;
import com.ecommerce.ecommerceApp.payload.response.AddressResponse;
import com.ecommerce.ecommerceApp.payload.response.RoleResponse;
import com.ecommerce.ecommerceApp.payload.response.UserRegisterResponse;
import com.ecommerce.ecommerceApp.repository.UserRepository;
import com.ecommerce.ecommerceApp.service.AuthService;
import com.ecommerce.ecommerceApp.utils.security.AccessToken;
import com.ecommerce.ecommerceApp.utils.security.ITokenProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public UserRegisterResponse userRegistration(UserRegisterRequest userRegisterRequest) {
        userRegisterRequest.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));
        User user = userRequestToUser(userRegisterRequest);
        List< Address> addresses = new ArrayList<>();
        for(AddressRequest addressRequest : userRegisterRequest.getAddressRequests()){
            addressRequest.setCity(addressRequest.getCity());
            addressRequest.setState(addressRequest.getState());
            addressRequest.setStreet(addressRequest.getStreet());
            addressRequest.setPinCode(addressRequest.getPinCode());
            addresses.add(addressRequestToAddress(addressRequest));
        }
        user.setAddresses(addresses);
        Cart cart = new Cart();
        user.setCart(cart);
        cart.setUser(user);
        User createdUser = userRepository.save(user);
        return userToUserResponse(createdUser);
    }

    @Override
    public AccessToken userLogin(UserLoginRequest userLoginRequest) {
        String username = userLoginRequest.getUsername();
        String password = userLoginRequest.getPassword();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        if(authentication.isAuthenticated()){
            Set<Role> roles = userRepository.findByUsername(username).get().getRoles();
            return tokenProvider.createToken(username,roles);
        }
        else {
            throw new UserNotFoundException("Invalid user credentials");
        }

    }

    @Override
    public List<UserRegisterResponse> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserRegisterResponse> userRegisterResponses = users.stream().map(this::userToUserResponse).toList();
        return userRegisterResponses;
    }

    public User userRequestToUser(UserRegisterRequest userRegisterRequest){
        return this.modelMapper.map(userRegisterRequest,User.class);
    }

    public Address addressRequestToAddress(AddressRequest addressRequest){
        return this.modelMapper.map(addressRequest, Address.class);
    }

    public AddressResponse addressToAddressResponse(Address address){
        return this.modelMapper.map(address,AddressResponse.class);
    }

    public RoleResponse roleToRoleResponse(Role role){
        return this.modelMapper.map(role,RoleResponse.class);
    }

    public UserRegisterResponse userToUserResponse(User user){
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setId(user.getId());
        userRegisterResponse.setName(user.getName());
        userRegisterResponse.setUsername(user.getUsername());
        userRegisterResponse.setEmail(user.getEmail());
        List<Address> addresses = user.getAddresses();
        List<AddressResponse> addressResponses = addresses.stream().map(this::addressToAddressResponse).toList();
        userRegisterResponse.setAddressResponses(addressResponses);
        Set<Role> roles = user.getRoles();
        Set<RoleResponse> roleResponses = roles.stream().map(this::roleToRoleResponse).collect(Collectors.toSet());
        userRegisterResponse.setRoleResponses(roleResponses);
        return userRegisterResponse;
    }
}
