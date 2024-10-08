package com.sparta.todojwt.service;

import com.sparta.todojwt.dto.*;
import com.sparta.todojwt.entity.Manager;
import com.sparta.todojwt.entity.Todo;
import com.sparta.todojwt.entity.User;
import com.sparta.todojwt.repository.ManagerRepository;
import com.sparta.todojwt.repository.TodoRepository;
import com.sparta.todojwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;

    @Transactional
    public TodoSaveResponseDto saveTodo(AuthUser authUser, TodoSaveRequestDto todoSaveRequestDto) {
        User createUser = userRepository.findById(authUser.getId()).orElseThrow(()-> new NullPointerException("유저 못찾음"));
        Todo newTodo = new Todo(
                createUser.getId(),
                todoSaveRequestDto.getTitle(),
                todoSaveRequestDto.getTodo()
        );
        Todo savedTodo = todoRepository.save(newTodo);
        return new TodoSaveResponseDto(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getTodo(),
                savedTodo.getCreatorId(),
                savedTodo.getCreatedAt(),
                savedTodo.getModifiedAt());
    }

    public TodoDetailResponseDto getTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()->new NullPointerException("일정 못찾음"));
        List<Manager> managerList = managerRepository.findAllByTodoId(todo.getId());
        return new TodoDetailResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getTodo(),
                todo.getCreatorId(),
                todo.getCreatedAt(),
                todo.getModifiedAt(),
                todo.getComments(),
                managerList
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
                todo.getCreatorId(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
    }

    public Page<TodoSimpleResponseDto> getTodos(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);
        return todos.map(todo -> new TodoSimpleResponseDto(
                todo.getTitle(),
                todo.getTodo(),
                todo.getComments().size(),
                todo.getCreatedAt(),
                todo.getModifiedAt(),
                todo.getCreatorId()
        ));
    }

    @Transactional
    public void deleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(()->new NullPointerException("일정 못찾음"));
        todoRepository.delete(todo);
    }
}
