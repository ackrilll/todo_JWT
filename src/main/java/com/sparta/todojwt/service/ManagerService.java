package com.sparta.todojwt.service;

import com.sparta.todojwt.dto.AuthUser;
import com.sparta.todojwt.dto.ManagerSaveRequestDto;
import com.sparta.todojwt.dto.ManagerSaveResponseDto;
import com.sparta.todojwt.entity.Manager;
import com.sparta.todojwt.entity.Todo;
import com.sparta.todojwt.entity.User;
import com.sparta.todojwt.repository.ManagerRepository;
import com.sparta.todojwt.repository.TodoRepository;
import com.sparta.todojwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ManagerService {
    private final ManagerRepository managerRepository;
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @Transactional
    public ManagerSaveResponseDto saveManager(AuthUser authUser, ManagerSaveRequestDto managerSaveRequestDto) {
        User currentUser = userRepository.findById(authUser.getId()).orElseThrow(() -> new NullPointerException("유저 못 찾음"));
        if (!currentUser.getId().equals(managerSaveRequestDto.getCreatorId())) {
            throw new NullPointerException("일정 작성자만 매니저를 등록할 수 있습니다.");
        }
        User managerUser = userRepository.findById(managerSaveRequestDto.getManagerId()).orElseThrow(() -> new NullPointerException("유저 못 찾음"));
        Todo todo = todoRepository.findById(managerSaveRequestDto.getTodoId()).orElseThrow(() -> new NullPointerException("일정 못찾음"));
        Manager newManager = new Manager(managerUser, todo);
        Manager savedManager = managerRepository.save(newManager);
        return new ManagerSaveResponseDto(
                savedManager.getTodo().getTitle(),
                savedManager.getUser().getId(),
                savedManager.getUser().getName(),
                savedManager.getTodo().getTodo()
        );
    }
}
