package com.example.todo2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserWithEmailResponseDto {
    private final String title;
    private final String contents;
    private final String email;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime updateAt;

    public UserWithEmailResponseDto(String title, String contents, String email, LocalDateTime createAt, LocalDateTime updateAt) {
        this.title = title;
        this.contents = contents;
        this.email = email;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
