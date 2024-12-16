package com.example.todo2.dto;

import lombok.Getter;

@Getter
public class UpdateTodoRequestDto {

    private final String title;
    private final String contents;

    public UpdateTodoRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
