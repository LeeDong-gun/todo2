package com.example.todo2.service;

import com.example.todo2.dto.UpdateUserRequestDto;
import com.example.todo2.dto.UserResponsDto;
import com.example.todo2.entity.User;
import com.example.todo2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * 유저 생성
     * @param username
     * @param email
     * @return
     */
    @Override
    public UserResponsDto userSave(String username, String email) {
        User user = new User(username, email);
        User savedUser = userRepository.save(user);
        return new UserResponsDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(), savedUser.getCreatedAt());
    }

    /**
     * 유저 전체 조회
     * @return
     */
    @Override
    public List<UserResponsDto> findAll() {
        return userRepository.findAll().stream().map(UserResponsDto::toDot).toList();
    }

    /**
     * 유저 단건 조회
     * @param id
     * @return
     */
    @Override
    public UserResponsDto findById(Long id) {
        User findUser = userRepository.findByIdOrElseThrow(id);
        return new UserResponsDto(findUser.getId(), findUser.getUsername(), findUser.getEmail(), findUser.getCreatedAt());
    }

    /**
     * 유저명 및 이메일 수정
     * @param id
     * @param requestDto
     * @return
     */
    @Override
    public UserResponsDto updateUser(Long id, UpdateUserRequestDto requestDto) {
        User updateUser = userRepository.findByIdOrElseThrow(id);
        if (requestDto.getUsername() == null && requestDto.getEmail() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The username and email are required values.");
        }
        if (requestDto.getUsername() != null) {
            updateUser.setUsername(requestDto.getUsername());
        }
        if (requestDto.getEmail() != null) {
            updateUser.setEmail(requestDto.getEmail());
        }
        userRepository.save(updateUser);
        return UserResponsDto.toDot(updateUser);
    }

    /**
     * 유저 삭제
     * @param id
     */
    @Override
    public void delete(Long id) {
        User deleteUser = userRepository.findByIdOrElseThrow(id);
        userRepository.delete(deleteUser);
    }
}
