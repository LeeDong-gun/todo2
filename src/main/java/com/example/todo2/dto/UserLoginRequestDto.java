package com.example.todo2.dto;

import lombok.Getter;

@Getter
public class UserLoginRequestDto {
    private final String email;
    private final String password;

    public UserLoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
