package com.example.todo2.service;

import com.example.todo2.dto.CommentResponseDto;
import com.example.todo2.dto.CreateCommentRequestDto;
import com.example.todo2.dto.updateRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface CommentService {
    CommentResponseDto commentSave(CreateCommentRequestDto requestDto);

    List<CommentResponseDto> commentByTodoId(Long todoId);

    CommentResponseDto udateComment(Long id, updateRequestDto requestDto);

    void delete(Long id);
}
