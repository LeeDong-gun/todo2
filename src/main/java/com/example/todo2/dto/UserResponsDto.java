package com.example.todo2.dto;

import com.example.todo2.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponsDto {
    private final Long id;
    private final String username;
    private final String email;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createAt;

    public UserResponsDto(Long id, String username, String email, LocalDateTime createAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createAt = createAt;
    }

    public static UserResponsDto toDot(User user) {
        return new UserResponsDto(user.getId(), user.getUsername(), user.getEmail(), user.getCreatedAt());
    }
}
