package com.example.todo2.dto;

import com.example.todo2.entity.Comment;
import com.example.todo2.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.aspectj.asm.IProgramElement;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

    private final Long id;
    private final String username; // 댓글 작성자
    private final String comment;
    private final Long todoId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime createAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime updateAt;

    public CommentResponseDto(Long id, String username, String comment,  Long todoId, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.username = username;
        this.comment = comment;
        this.todoId = todoId;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public static CommentResponseDto toDto(Comment comment) {
        return new CommentResponseDto(comment.getId(), comment.getUser().getUsername(), comment.getComment(), comment.getTodo().getId(), comment.getCreatedAt(), comment.getUpdatedAt());
    }
}
