package com.example.todo2.service;

import com.example.todo2.dto.UpdateUserRequestDto;
import com.example.todo2.dto.UserResponsDto;

import java.util.List;

public interface UserService {
    UserResponsDto userSave(String username, String email);

    List<UserResponsDto> findAll();

    UserResponsDto findById(Long id);

    UserResponsDto updateUser(Long id, UpdateUserRequestDto requestDto);

    void delete(Long id);
}
