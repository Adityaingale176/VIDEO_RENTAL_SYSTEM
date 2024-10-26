package com.example.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springsecurity.Respository.UserRepository;
import com.example.springsecurity.exchanges.request.AuthRequest;
import com.example.springsecurity.exchanges.request.RegisterRequest;
import com.example.springsecurity.exchanges.response.AuthResponse;
import com.example.springsecurity.model.User;
import com.example.springsecurity.model.enums.Role;


@Service
public class AuthService {

    @Autowired
    UserRepository userepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    public AuthResponse login(AuthRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        return AuthResponse.builder().build();
    }

    public AuthResponse register(RegisterRequest request){
        if(request.getRole() == null){
            request.setRole(Role.CUSTOMER);
        }

        User user = User.builder()
                                    .email(request.getEmail())
                                    .firstName(request.getFirstName())
                                    .lastName(request.getLastName())
                                    .password(passwordEncoder.encode(request.getPassword()))
                                    .role(request.getRole())
                                    .build();
                                    
        userepository.save(user);

        return AuthResponse.builder().build();
    }

}
