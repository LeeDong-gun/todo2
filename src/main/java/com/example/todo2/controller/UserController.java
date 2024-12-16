package com.example.todo2.controller;

import com.example.todo2.dto.CreateUserRequestDto;
import com.example.todo2.dto.UpdateUserRequestDto;
import com.example.todo2.dto.UserResponsDto;
import com.example.todo2.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 유저 생성
     *
     * @param requestDto
     * @return
     */
    @PostMapping
    public ResponseEntity<UserResponsDto> userSave(@RequestBody CreateUserRequestDto requestDto) {
        UserResponsDto userResponsDto = userService.userSave(requestDto.getUsername(), requestDto.getEmail());

        return new ResponseEntity<>(userResponsDto, HttpStatus.CREATED);
    }

    /**
     * 유저 전체 조회
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<UserResponsDto>> findAll() {
        List<UserResponsDto> userResponsDtoList = userService.findAll();
        return new ResponseEntity<>(userResponsDtoList, HttpStatus.OK);
    }

    /**
     * 유저 단건 조회
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponsDto> findById(@PathVariable Long id) {
        UserResponsDto byId = userService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    /**
     * 유저명 및 이메일 수정
     *
     * @param id
     * @param requestDto
     * @return
     */
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponsDto> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequestDto requestDto
    ) {
        return ResponseEntity.ok(userService.updateUser(id, requestDto));
    }

    /**
     * 유저 삭제
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
