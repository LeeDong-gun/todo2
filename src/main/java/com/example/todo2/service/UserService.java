package com.example.todo2.service;

import com.example.todo2.dto.UpdateUserRequestDto;
import com.example.todo2.dto.UserLoginRequestDto;
import com.example.todo2.dto.UserResponsDto;

import java.util.List;

public interface UserService {
    UserResponsDto userSave(String username,String password , String email);

    List<UserResponsDto> findAll();

    UserResponsDto findById(Long id);

    UserResponsDto updateUser(Long id, UpdateUserRequestDto requestDto);

    void delete(Long id);

    void updatePassword(Long id, String oldPassword, String newPassword);

    boolean login(UserLoginRequestDto requestDto);
}
