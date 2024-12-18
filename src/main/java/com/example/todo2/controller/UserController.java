package com.example.todo2.controller;

import com.example.todo2.dto.*;
import com.example.todo2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.smartcardio.ResponseAPDU;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 회원가입
     *
     * @param requestDto
     * @return
     */
    @PostMapping("/signup")
    public ResponseEntity<UserResponsDto> userSave(@Valid @RequestBody CreateUserRequestDto requestDto) {
        UserResponsDto userResponsDto = userService.userSave(requestDto.getUsername(), requestDto.getPassword(), requestDto.getEmail());

        return new ResponseEntity<>(userResponsDto, HttpStatus.CREATED);
    }

    /**
     * 유저 전체 조회
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
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 비밀번호 변경
     *
     * @param id
     * @param requestDto
     * @return
     */
    @PatchMapping("/password/{id}")
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequestDto requestDto
    ) {
        userService.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 로그인
     * @param requestDto
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody UserLoginRequestDto requestDto,
            HttpServletRequest request
    ) {
        boolean loginSuccess = userService.login(requestDto);
        if (loginSuccess) {
            HttpSession session = request.getSession();
            session.setAttribute("user", requestDto);
            return ResponseEntity.ok("로그인 성공");
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * 로그아웃
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok("로그아웃 되었습니다.");
    }
}
