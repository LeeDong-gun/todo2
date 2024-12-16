package com.example.todo2.service;


import com.example.todo2.dto.TodoResponseDto;
import com.example.todo2.dto.UpdateTodoRequestDto;
import com.example.todo2.entity.Todo;
import com.example.todo2.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    /**
     * 일정생성
     * @param username
     * @param title
     * @param contents
     * @return
     */
    @Override
    public TodoResponseDto todoSave(String username, String title, String contents) {
        Todo todo = new Todo(username, title, contents);

        Todo saveTodo = todoRepository.save(todo);
        return new TodoResponseDto(saveTodo.getId(), saveTodo.getUsername(), saveTodo.getTitle(), saveTodo.getContents(), saveTodo.getCreatedAt(), saveTodo.getUpdatedAt());
    }

    /**
     * 일정 전체 조회
     * @return
     */
    @Override
    public List<TodoResponseDto> findAll() {
        return todoRepository.findAll().stream().map(TodoResponseDto::toDto).toList();
    }

    /**
     * 일정 단건 조회
     * @param id
     * @return
     */
    @Override
    public TodoResponseDto findById(Long id) {

        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        return new TodoResponseDto(findTodo.getId(), findTodo.getUsername(), findTodo.getTitle(), findTodo.getContents(), findTodo.getCreatedAt(), findTodo.getUpdatedAt());
    }

    /**
     * 제목 및 일정 수정
     * @param id
     * @param requestDto
     * @return
     */
    @Override
    public TodoResponseDto updatrTodo(Long id, UpdateTodoRequestDto requestDto) {
        Todo updateTodo = todoRepository.findByIdOrElseThrow(id);
        if (requestDto.getTitle() == null && requestDto.getContents() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and todo are required values.");
        }
        if (requestDto.getTitle() != null) {
            updateTodo.setTitle(requestDto.getTitle());
        }
        if (requestDto.getContents() != null) {
            updateTodo.setContents(requestDto.getContents());
        }
        todoRepository.save(updateTodo);
        return TodoResponseDto.toDto(updateTodo);
    }

    @Override
    public void delete(Long id) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);
        todoRepository.delete(findTodo);
    }
}
