package com.example.todo2.dto;

import lombok.Getter;

@Getter
public class CreateUserRequestDto {
    private final String username;
    private final String email;

    public CreateUserRequestDto(Long id, String username, String email) {
        this.username = username;
        this.email = email;
    }
}
