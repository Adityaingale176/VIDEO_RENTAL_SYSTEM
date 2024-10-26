package com.example.springsecurity.exchanges.request;

import com.example.springsecurity.model.enums.Role;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthRequest {

    private String email;
    private String password;

}
