package com.sparta.todojwt.controller;

import com.sparta.todojwt.dto.UserSaveRequestDto;
import com.sparta.todojwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody UserSaveRequestDto userSaveRequestDto){
        String bearerToken = userService.createUser(
                userSaveRequestDto.getUsername(),
                userSaveRequestDto.getEmail(),
                userSaveRequestDto.getPassword());
        return ResponseEntity.ok()
                .header("Authorization", bearerToken)
                .build();
    }

}
