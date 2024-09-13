package com.sparta.todojwt.dto;

import lombok.Getter;

@Getter
public class UserSimpleResponseDto {
    private final Long id;
    private final String name;

    public UserSimpleResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
