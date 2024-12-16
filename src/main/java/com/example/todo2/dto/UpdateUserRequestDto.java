package com.example.todo2.dto;

import lombok.Getter;

@Getter
public class UpdateUserRequestDto {

    private final String username;
    private final String email;

    public UpdateUserRequestDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
