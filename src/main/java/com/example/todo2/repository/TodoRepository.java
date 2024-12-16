package com.example.todo2.repository;

import com.example.todo2.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    /**
     * 일정조회 없는 id 입력시
     * @param id
     * @return
     */
    default Todo findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }
}