package com.example.todo2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Singular;

@Getter
public class UpdateTodoRequestDto {

    @NotBlank(message = "제목을 입력해주세요")
    @Size(max = 10, message = "10 글자 이내여야 합니다.")
    private final String title;
    @NotBlank(message = "일정을 입력해주세요.")
    @Size(max = 10, message = "10 글자 이내여야 합니다.")
    private final String contents;

    public UpdateTodoRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
