package com.example.todo2.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateUserRequestDto {

    @NotBlank(message = "제목을 입력해주세요.")
    @Size(max = 4, message = "유저명 최대 4글자")
    private final String username;
    @NotBlank(message = "email을 입력해주세요.")
    @Email
    private final String email;


    public UpdateUserRequestDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
