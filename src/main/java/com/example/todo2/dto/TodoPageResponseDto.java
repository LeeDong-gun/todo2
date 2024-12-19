package com.example.todo2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoPageResponseDto {

    private String title;
    private String content;
    private Long commentCount;
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;

    public TodoPageResponseDto(String title, String contents, Long commentCount, String username, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.content = contents;
        this.commentCount = commentCount;
        this.username = username;
        this.createAt = createdAt;
        this.updateAt = updatedAt;
    }
}
