package com.ecommerce.ecommerceApp.config.security;

import com.ecommerce.ecommerceApp.exception.security.CustomSecurityException;
import com.ecommerce.ecommerceApp.utils.constant.ApiMessage;
import com.ecommerce.ecommerceApp.utils.security.AccessToken;
import com.ecommerce.ecommerceApp.utils.security.ITokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author Divakar Verma
 * @created_at : 15/01/2024 - 11:25 am
 * @mail_to: vermadivakar2022@gmail.com
 */
@Component
public class TokenFilter extends OncePerRequestFilter {


    @Autowired
    private ITokenProvider tokenProvider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        AccessToken accessToken = tokenProvider.getTokenFromHeader(request);
//        String token = null;
//        String username = null;
//        if(accessToken.getAccessToken()!=null && accessToken.getAccessToken().startsWith("Bearer ")){
//            token = accessToken.getAccessToken().substring(7);
//
//        }
        try {
            if(checkAccessToken(accessToken)){
                Authentication authentication = tokenProvider.getAuthentication(accessToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request,response);
        }
        catch (CustomSecurityException customSecurityException){
            SecurityContextHolder.clearContext();
            throw  customSecurityException;
        }

    }

    private boolean checkAccessToken(AccessToken accessToken){
        if(accessToken==null){
            return false;
        }
        return tokenProvider.validateToken(accessToken);
    }
}
