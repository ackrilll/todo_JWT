package com.sparta.todojwt.controller;

import com.sparta.todojwt.dto.AuthUser;
import com.sparta.todojwt.dto.TodoSaveRequestDto;
import com.sparta.todojwt.dto.TodoSaveResponseDto;
import com.sparta.todojwt.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<TodoSaveResponseDto> saveTodo(AuthUser authUser,
                                                        @RequestBody TodoSaveRequestDto todoSaveRequestDto){
        return ResponseEntity.ok(todoService.saveTodo(authUser, todoSaveRequestDto));
    }

}
