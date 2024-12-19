package com.example.todo2.repository;

import com.example.todo2.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    /**
     * 댓글 조회
     * @param pageable
     * @return
     */
    @Query("SELECT t, COUNT(c.id) as commentCount " +
            "FROM Todo t " +
            "LEFT JOIN Comment c ON c.todo = t " +
            "JOIN t.user u " +
            "GROUP BY t.id " +
            "ORDER BY t.updatedAt DESC")
    Page<Object[]> findTodosWithCommentCount(Pageable pageable);

    /**
     * 일정조회 없는 id 입력시
     * @param id
     * @return
     */
    default Todo findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }
}
