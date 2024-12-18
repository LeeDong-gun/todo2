package com.example.todo2.service;

import com.example.todo2.config.PasswordEncoder;
import com.example.todo2.dto.UpdateUserRequestDto;
import com.example.todo2.dto.UserLoginRequestDto;
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
    private final PasswordEncoder passwordEncoder;

    /**
     * 유저 생성
     * @param username
     * @param password
     * @param email
     * @return
     */
    @Override
    public UserResponsDto userSave(String username, String password, String email) {
        String encodePassword = passwordEncoder.encode(password);
        User user = new User(username, encodePassword, email);
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

    /**
     * 비밀번호 변경
     * @param id
     * @param oldPassword
     * @param newPassword
     */
    @Override
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        User findUser = userRepository.findByIdOrElseThrow(id);
        if (!passwordEncoder.matches(oldPassword, findUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "이전 비밀번호가 일치하지 않습니다.");
        }
        findUser.updatePassword(passwordEncoder.encode(newPassword));
    }

    /**
     * 로그인
     * @param requestDto
     * @return
     */
    @Override
    public boolean login(UserLoginRequestDto requestDto) {
        User findUser = userRepository.findByEmailOrElseThrow(requestDto.getEmail());

        if (!passwordEncoder.matches(requestDto.getPassword(), findUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        return true;
    }
}
