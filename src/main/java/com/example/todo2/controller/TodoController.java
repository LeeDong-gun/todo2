package com.example.todo2.controller;

import com.example.todo2.dto.CreateTodoRequestDto;
import com.example.todo2.dto.TodoResponseDto;
import com.example.todo2.dto.UpdateTodoRequestDto;
import com.example.todo2.service.TodoService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<TodoResponseDto> todoSave(@RequestBody CreateTodoRequestDto requestDto) {

        TodoResponseDto todoResponseDto = todoService.todoSave(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
    }

    /**
     * 일정 전체 조회
     *
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
    public ResponseEntity<TodoResponseDto> findById(@PathVariable Long id) {
        TodoResponseDto byId = todoService.findById(id);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}