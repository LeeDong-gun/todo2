package com.example.todo2.service;

import com.example.todo2.dto.TodoResponseDto;
import com.example.todo2.dto.UpdateTodoRequestDto;

import java.util.List;

public interface TodoService {
    TodoResponseDto todoSave(String username, String title, String contents);

    List<TodoResponseDto> findAll();

    TodoResponseDto findById(Long id);

    TodoResponseDto updatrTodo(Long id, UpdateTodoRequestDto requestDto);

    void delete(Long id);
}
