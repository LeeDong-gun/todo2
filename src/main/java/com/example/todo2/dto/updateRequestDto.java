package com.example.todo2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class updateRequestDto {

    @NotBlank(message = "댓글을 작성해주세요.")
    private final String comment;

    public updateRequestDto(String comment) {
        this.comment = comment;
    }
}
