package com.sparta.todojwt.controller;

import com.sparta.todojwt.dto.*;
import com.sparta.todojwt.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<TodoSaveResponseDto> saveTodo(AuthUser authUser,
                                                        @RequestBody TodoSaveRequestDto todoSaveRequestDto){
        return ResponseEntity.ok(todoService.saveTodo(authUser, todoSaveRequestDto));
    }

    @GetMapping("/todos/{todoId}")
    public ResponseEntity<TodoDetailResponseDto> getTodo(@PathVariable Long todoId){
        return ResponseEntity.ok(todoService.getTodo(todoId));
    }

    @PutMapping("todos/{todoId}")
    public ResponseEntity<TodoUpdateResponseDto> updateTodo(@PathVariable Long todoId,
                                                            @RequestBody TodoUpdateRequestDto todoUpdateRequestDto){
        return ResponseEntity.ok(todoService.updateTodo(todoId, todoUpdateRequestDto));
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<TodoSimpleResponseDto>> getTodos(
            @RequestParam (defaultValue = "1", required = false)int page,
            @RequestParam (defaultValue = "10", required = false)int size
    ){
        return ResponseEntity.ok(todoService.getTodos(page,size));
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId){
        todoService.deleteTodo(todoId);
    }

}
