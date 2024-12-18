package com.example.todo2.controller;

import com.example.todo2.dto.CommentResponseDto;
import com.example.todo2.dto.CreateCommentRequestDto;
import com.example.todo2.dto.updateRequestDto;
import com.example.todo2.entity.Comment;
import com.example.todo2.service.CommentService;
import com.example.todo2.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글생성
     *
     * @param requestDto
     * @return
     */
    @PostMapping
    public ResponseEntity<CommentResponseDto> commentSave(@Valid @RequestBody CreateCommentRequestDto requestDto) {
        CommentResponseDto commentResponseDto = commentService.commentSave(requestDto);
        return new ResponseEntity<>(commentResponseDto, HttpStatus.CREATED);
    }

    /**
     * 일정별 댓글 조회
     *
     * @param todoId
     * @return
     */
    @GetMapping("/todos/{todoId}")
    public ResponseEntity<List<CommentResponseDto>> commentByTodoId(@PathVariable Long todoId) {
        List<CommentResponseDto> commentResponseDtoList = commentService.commentByTodoId(todoId);
        return new ResponseEntity<>(commentResponseDtoList, HttpStatus.OK);
    }

    /**
     * 댓글 수정
     *
     * @param id
     * @param requestDto
     * @return
     */
    @PatchMapping("/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @PathVariable Long id,
            @Valid @RequestBody updateRequestDto requestDto
    ) {
        return ResponseEntity.ok(commentService.udateComment(id, requestDto));
    }

    /**
     * 댓글 삭제
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
