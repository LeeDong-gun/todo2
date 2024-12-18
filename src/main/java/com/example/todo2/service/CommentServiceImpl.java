package com.example.todo2.service;

import com.example.todo2.dto.CommentResponseDto;
import com.example.todo2.dto.CreateCommentRequestDto;
import com.example.todo2.dto.updateRequestDto;
import com.example.todo2.entity.Comment;
import com.example.todo2.entity.Todo;
import com.example.todo2.entity.User;
import com.example.todo2.repository.CommentRepository;
import com.example.todo2.repository.TodoRepository;
import com.example.todo2.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    /**
     * 댓글 생성
     * @param requestDto
     * @return
     */
    @Override
    public CommentResponseDto commentSave(CreateCommentRequestDto requestDto) {
        User createUser = userRepository.findByIdOrElseThrow(requestDto.getUserId());
        Todo todo = todoRepository.findByIdOrElseThrow(requestDto.getTodoId());

        Comment comment = new Comment();
        comment.setUser(createUser);
        comment.setComment(requestDto.getComment());
        comment.setTodo(todo);

        Comment saveComment = commentRepository.save(comment);
        return new CommentResponseDto(saveComment.getId(), saveComment.getUser().getUsername(), saveComment.getComment(), saveComment.getTodo().getId(), saveComment.getCreatedAt(), saveComment.getUpdatedAt());
    }

    /**
     * 일정별 댓글 조회
     * @param todoId
     * @return
     */
    @Override
    public List<CommentResponseDto> commentByTodoId(Long todoId) {
        return commentRepository.findAll().stream().filter(comment -> comment.getTodo().getId().equals(todoId)).map(CommentResponseDto::toDto).toList();
    }

    /**
     * 댓글 수정
     * @param id
     * @param requestDto
     * @return
     */
    @Override
    public CommentResponseDto udateComment(Long id, updateRequestDto requestDto) {
        Comment updatecomment = commentRepository.findByIdOrElseThrow(id);
        if (requestDto.getComment() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The comment is required values.");
        }
        updatecomment.setComment(requestDto.getComment());
        commentRepository.save(updatecomment);
        return CommentResponseDto.toDto(updatecomment);
    }

    /**
     * 댓글 삭제
     * @param id
     */
    @Override
    public void delete(Long id) {
        Comment findComment = commentRepository.findByIdOrElseThrow(id);
        commentRepository.delete(findComment);
    }
}
