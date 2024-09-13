package com.sparta.todojwt.controller;

import com.sparta.todojwt.dto.UserSaveRequestDto;
import com.sparta.todojwt.dto.UserSimpleResponseDto;
import com.sparta.todojwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody UserSaveRequestDto userSaveRequestDto){
        String bearerToken = userService.createUser(
                userSaveRequestDto.getUsername(),
                userSaveRequestDto.getEmail()
                );
        return ResponseEntity.ok()
                .header("Authorization", bearerToken)
                .build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserSimpleResponseDto>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

}
