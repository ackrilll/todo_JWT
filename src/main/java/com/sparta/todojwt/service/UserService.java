package com.sparta.todojwt.service;

import com.sparta.todojwt.config.JwtUtil;
import com.sparta.todojwt.dto.UserSimpleResponseDto;
import com.sparta.todojwt.entity.User;
import com.sparta.todojwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;


    @Transactional
    public String createUser(String name, String email) {
        User newUser = new User(name, email);
        User savedUser = userRepository.save(newUser);
        return jwtUtil.createToken(savedUser.getId());

    }

    public List<UserSimpleResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserSimpleResponseDto> userDto = new ArrayList<>();
        for (User user : users) {
            UserSimpleResponseDto userSimpleResponseDto = new UserSimpleResponseDto(user.getId(),user.getName());
            userDto.add(userSimpleResponseDto);
        }
        return userDto;
    }
}
