package com.example.todo2.service;

import com.example.todo2.dto.TodoResponseDto;
import com.example.todo2.dto.UpdateTodoRequestDto;
import com.example.todo2.dto.UserWithEmailResponseDto;

import java.util.List;

public interface TodoService {
    TodoResponseDto todoSave(String username, String title, String contents);

    List<TodoResponseDto> findAll();

    TodoResponseDto updatrTodo(Long id, UpdateTodoRequestDto requestDto);

    void delete(Long id);

    UserWithEmailResponseDto findById(Long id);
}
