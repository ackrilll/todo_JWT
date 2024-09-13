package com.sparta.todojwt.service;

import com.sparta.todojwt.config.JwtUtil;
import com.sparta.todojwt.entity.User;
import com.sparta.todojwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;


    @Transactional
    public String createUser(String name, String email, String password) {
        User newUser = new User(name, email, password);
        User savedUser = userRepository.save(newUser);
        return jwtUtil.createToken(savedUser.getId());

    }
}
