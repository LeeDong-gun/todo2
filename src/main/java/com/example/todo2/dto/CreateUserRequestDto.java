package com.example.todo2.dto;

import lombok.Getter;

@Getter
public class CreateUserRequestDto {
    private final String username;
    private final String password;
    private final String email;

    public CreateUserRequestDto(Long id, String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
