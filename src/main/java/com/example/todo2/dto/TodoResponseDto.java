package com.example.todo2.dto;

import com.example.todo2.entity.Todo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {

    private final Long id;

    private final String title;

    private final String contents;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime updateAt;

    public TodoResponseDto(Long id, String title, String contents, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }



    public static TodoResponseDto toDto(Todo todo) {
        return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContents(), todo.getCreatedAt(), todo.getUpdatedAt());
    }

}
