package com.example.todo2.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class UserLoginRequestDto {

    @Email
    private final String email;
    private final String password;

    public UserLoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
