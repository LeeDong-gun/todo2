package com.example.todo2.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateUserRequestDto {
    @NotBlank(message = "유저명을 입력해주세요.")
    @Size(max = 4, message = "유저명 최대 4글자")
    private final String username;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private final String password;
    @NotBlank(message = "email을 입력해주세요.")
    @Email
    private final String email;

    public CreateUserRequestDto(Long id, String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
