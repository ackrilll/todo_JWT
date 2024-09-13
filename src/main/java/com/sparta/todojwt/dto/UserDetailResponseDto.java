package com.sparta.todojwt.dto;

import lombok.Getter;

@Getter
public class UserDetailResponseDto {
    private final Long id;
    private final String name;
    private final String email;

    public UserDetailResponseDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
