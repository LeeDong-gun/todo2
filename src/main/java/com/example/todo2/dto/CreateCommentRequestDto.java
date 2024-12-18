package com.example.todo2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateCommentRequestDto {

    @NotBlank(message = "댓글 내용을 적어주세요.")
    private final String comment;
    private final Long todoId; //댓글 달릴 일정
    private final Long userId; // 댓글 작성자

    public CreateCommentRequestDto(String comment, Long todoId, Long userId) {
        this.comment = comment;
        this.todoId = todoId;
        this.userId = userId;
    }
}
