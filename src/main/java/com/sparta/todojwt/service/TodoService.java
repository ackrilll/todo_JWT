package com.sparta.todojwt.service;

import com.sparta.todojwt.dto.*;
import com.sparta.todojwt.entity.Todo;
import com.sparta.todojwt.repository.TodoRepository;
import com.sparta.todojwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public TodoSaveResponseDto saveTodo(AuthUser authUser, TodoSaveRequestDto todoSaveRequestDto) {
        Todo newTodo = new Todo(
                userRepository.findById(authUser.getId()).orElseThrow(()-> new NullPointerException("유저 못찾음")),
                todoSaveRequestDto.getTitle(),
                todoSaveRequestDto.getTodo()
        );
        Todo savedTodo = todoRepository.save(newTodo);
        return new TodoSaveResponseDto(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getTodo(),
                savedTodo.getUser().getName(),
                savedTodo.getCreatedAt(),
                savedTodo.getModifiedAt());
    }

    public TodoDetailResponseDto getTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()->new NullPointerException("일정 못찾음"));
        return new TodoDetailResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getTodo(),
                todo.getUser().getName(),
                todo.getCreatedAt(),
                todo.getModifiedAt(),
                todo.getComments()
        );

    }

    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto todoUpdateRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()->new NullPointerException("일정 못찾음"));
        todo.update(todoUpdateRequestDto.getTitle(), todoUpdateRequestDto.getTodo());
        return new TodoUpdateResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getTodo(),
                todo.getUser().getName(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
    }
}
