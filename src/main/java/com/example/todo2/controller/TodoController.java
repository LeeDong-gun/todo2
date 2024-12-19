package com.example.todo2.controller;

import com.example.todo2.dto.*;
import com.example.todo2.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    /**
     * 일정 생성
     *
     * @param requestDto
     * @return
     */
    @PostMapping
    public ResponseEntity<TodoResponseDto> todoSave(@Valid @RequestBody CreateTodoRequestDto requestDto) {

        TodoResponseDto todoResponseDto = todoService.todoSave(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
    }

    /**
     * 일정 전체 조회
     * @return
     */
    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> findAll() {
        List<TodoResponseDto> todoResponseDtoList = todoService.findAll();
        return new ResponseEntity<>(todoResponseDtoList, HttpStatus.OK);
    }

    /**
     * 일정 단건 조회
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserWithEmailResponseDto> findById(@PathVariable Long id) {
        UserWithEmailResponseDto byId = todoService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    /**
     * 제목 및 일정 수정
     *
     * @param id
     * @param requestDto
     * @return
     */
    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo(
            @PathVariable Long id,
            @RequestBody UpdateTodoRequestDto requestDto
    ) {
        return ResponseEntity.ok(todoService.updatrTodo(id, requestDto));
    }

    /**
     * 일정 삭제
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 일정 페이징 조회
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/gettodos")
    public ResponseEntity<Page<TodoPageResponseDto>> getTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<TodoPageResponseDto> todos = todoService.getTodosWithPagination(page, size);

        return ResponseEntity.ok(todos);
    }
}
